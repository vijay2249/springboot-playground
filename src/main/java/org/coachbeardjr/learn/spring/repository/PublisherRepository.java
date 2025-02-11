package org.coachbeardjr.learn.spring.repository;

import org.coachbeardjr.learn.spring.model.Publisher;
import org.springframework.data.r2dbc.repository.Query;
import org.springframework.data.r2dbc.repository.R2dbcRepository;

import reactor.core.publisher.Mono;

public interface PublisherRepository extends R2dbcRepository<Publisher, Long>{

  @Override
  @Query("insert into publishers (id, name, address) values (:#{#publisher.id}, :#{#publisher.name}, :#{#publisher.address})")
  Mono<Publisher> save(Publisher publisher);
}
