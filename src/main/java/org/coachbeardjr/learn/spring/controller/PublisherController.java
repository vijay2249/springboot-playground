package org.coachbeardjr.learn.spring.controller;

import org.coachbeardjr.learn.spring.model.Publisher;
import org.coachbeardjr.learn.spring.repository.PublisherRepository;
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
@RequestMapping("/publisher")
@RequiredArgsConstructor
public class PublisherController {
  private final PublisherRepository publisherRepository;

  @PostMapping
  public ResponseEntity<Mono<Publisher>> newPublisher(@RequestBody Publisher publisher){
    Mono<Publisher> newAuthor = publisherRepository.save(publisher);
    return ResponseEntity.ok(newAuthor);
  }

  @GetMapping("/{id}")
  public ResponseEntity<Mono<Publisher>> getPublisher(@PathVariable Long id){
    Mono<Publisher> author = publisherRepository.findById(id);
    if(author == null){
      return ResponseEntity.notFound().build();
    }
    return ResponseEntity.ok(author);
  }

  @DeleteMapping("/{id}")
  public ResponseEntity<Void> deletePublisher(@PathVariable Long id){
    if(publisherRepository.existsById(id) != null){
      publisherRepository.deleteById(id);
      return ResponseEntity.ok().build();
    }
    return ResponseEntity.notFound().build();
  }

  @PutMapping("/{id}")
  public ResponseEntity<Mono<Publisher>> updatePublisher(@PathVariable Long id, @RequestBody Publisher newPublisherData){
    Mono<Publisher> updatedPublisher = publisherRepository.findById(id)
      .doOnNext( existingPublisher ->{
        existingPublisher.setAddress(newPublisherData.getAddress());
        existingPublisher.setName(newPublisherData.getName());
        publisherRepository.save(existingPublisher);
      });
    return ResponseEntity.ok(updatedPublisher);
  }
}
