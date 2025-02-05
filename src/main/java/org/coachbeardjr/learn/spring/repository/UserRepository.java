package org.coachbeardjr.learn.spring.repository;

import org.coachbeardjr.learn.spring.model.User;
import org.springframework.data.r2dbc.repository.R2dbcRepository;

import reactor.core.publisher.Mono;

public interface UserRepository extends R2dbcRepository<User, String>{
  Mono<User> findByEmail(String email); //returns a single user

}
