package org.coachbeardjr.learn.spring.controller;

import org.coachbeardjr.learn.spring.model.Author;
import org.coachbeardjr.learn.spring.repository.AuthorRepository;
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
@RequestMapping("/author")
@RequiredArgsConstructor
public class AuthorController {
  private final AuthorRepository authorRepository;

  @PostMapping
  public ResponseEntity<Mono<Author>> newAuthor(@RequestBody Author author){
    Mono<Author> newAuthor = authorRepository.save(author);
    return ResponseEntity.ok(newAuthor);
  }

  @GetMapping("/{id}")
  public ResponseEntity<Mono<Author>> getAuthor(@PathVariable Long id){
    Mono<Author> author = authorRepository.findById(id);
    if(author == null){
      return ResponseEntity.notFound().build();
    }
    return ResponseEntity.ok(author);
  }

  @DeleteMapping("/{id}")
  public ResponseEntity<Void> deleteAuthor(@PathVariable Long id){
    if(authorRepository.existsById(id) != null){
      authorRepository.deleteById(id);
      return ResponseEntity.ok().build();
    }
    return ResponseEntity.notFound().build();
  }

  @PutMapping("/{id}")
  public ResponseEntity<Mono<Author>> updateAuthor(@PathVariable Long id, @RequestBody Author newAuthorData){
    Mono<Author> updatedAuthor = authorRepository.findById(id)
      .doOnNext( existingAuthor ->{
        existingAuthor.setBiography(newAuthorData.getBiography());
        existingAuthor.setName(newAuthorData.getName());
        existingAuthor.setPublisher(newAuthorData.getPublisher());
        authorRepository.save(existingAuthor);
      });
    return ResponseEntity.ok(updatedAuthor);
  }
}
