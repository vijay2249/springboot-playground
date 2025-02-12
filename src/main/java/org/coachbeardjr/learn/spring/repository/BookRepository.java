package org.coachbeardjr.learn.spring.repository;

import org.coachbeardjr.learn.spring.model.Book;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.data.r2dbc.repository.R2dbcRepository;

import reactor.core.publisher.Mono;

public interface  BookRepository extends R2dbcRepository<Book, Long> {
  
  @Override
  @Cacheable
  Mono<Book> findById(Long id);
}
