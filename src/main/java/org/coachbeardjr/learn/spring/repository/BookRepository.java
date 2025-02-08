package org.coachbeardjr.learn.spring.repository;

import org.coachbeardjr.learn.spring.model.Book;
import org.springframework.data.r2dbc.repository.R2dbcRepository;

public interface  BookRepository extends R2dbcRepository<Book, Long> {
  
}
