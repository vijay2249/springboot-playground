package org.coachbeardjr.learn.spring.repository;

import org.coachbeardjr.learn.spring.model.Publisher;
import org.springframework.data.r2dbc.repository.R2dbcRepository;

public interface PublisherRepository extends R2dbcRepository<Publisher, Long>{
  
}
