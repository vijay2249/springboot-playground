package org.coachbeardjr.learn.spring.controller;

import org.coachbeardjr.learn.spring.model.Book;
import org.coachbeardjr.learn.spring.repository.BookRepository;
import org.springframework.cache.annotation.CacheEvict;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import lombok.RequiredArgsConstructor;
import reactor.core.publisher.Mono;

@RestController
@RequestMapping("/books")
@RequiredArgsConstructor
public class BookController {
  private final BookRepository bookRepository;

  @PostMapping
  @CacheEvict(value="books", allEntries=true)
  public ResponseEntity<Mono<Book>> addBook(@RequestBody Book book){
    Mono<Book> savedBook = bookRepository.save(book);
    return ResponseEntity.ok(savedBook);
  }

  @GetMapping("/{id}")
  public ResponseEntity<Mono<Book>> getBook(@PathVariable Long id){
    Mono<Book> book = bookRepository.findById(id);
    if(book == null){
      return ResponseEntity.notFound().build();
    }
    return ResponseEntity.ok(book);
  }

  @DeleteMapping("/{id}")
  @CacheEvict(value="books", key="#id")
  public ResponseEntity<Void> deleteBook(@PathVariable Long id){
    if(bookRepository.existsById(id) != null){
      bookRepository.deleteById(id);
      return ResponseEntity.ok().build();
    }
    return ResponseEntity.notFound().build();
  }

  @PutMapping("/{id}")
  @CacheEvict(value="books", allEntries=true)
  public ResponseEntity<Mono<Book>> updateBook(@PathVariable Long id, @RequestBody Book newBookData){
    Mono<Book> updatedBook = bookRepository.findById(id)
      .doOnNext(existingBook ->{
        existingBook.setAuthors(newBookData.getAuthors());
        existingBook.setIsbn(newBookData.getIsbn());
        existingBook.setTitle(newBookData.getTitle());
        bookRepository.save(existingBook);
      });
    return ResponseEntity.ok(updatedBook);
  }
}
