package org.coachbeardjr.learn.spring.repository;

import org.coachbeardjr.learn.spring.model.Author;
import org.springframework.data.r2dbc.repository.R2dbcRepository;

public interface AuthorRepository extends R2dbcRepository<Author, Long>{
  
}
