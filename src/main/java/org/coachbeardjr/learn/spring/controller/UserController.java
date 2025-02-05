package org.coachbeardjr.learn.spring.controller;

import org.coachbeardjr.learn.spring.exception.EmailUniquenessException;
import org.coachbeardjr.learn.spring.model.User;
import org.coachbeardjr.learn.spring.repository.UserRepository;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

@RestController
@RequestMapping("/users")
public class UserController {
  private final UserRepository userRepository;

  public UserController(UserRepository userRepository){
    this.userRepository = userRepository;
  }

  // @PostMapping
  // public Mono<User> createUser(@RequestBody User user){
  //   return userRepository.save(user);
  // }

  @PostMapping("/")
  public Mono<ResponseEntity<User>> createUser(@RequestBody User user){
    return userRepository.findByEmail(user.email())
    .flatMap(existingUser -> Mono.error(new EmailUniquenessException("Email must be unique")))
    .then(userRepository.save(user))
    .map(ResponseEntity::ok)
    .doOnNext(savedUser -> System.out.println("user cretated"))
    .onErrorResume(e -> {
      System.out.println("Exception occured");
      System.out.println(e.getMessage());
      return Mono.just(ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).build());
    });
  }

  @GetMapping
  public Flux<User> getAllUsers() {
    return userRepository.findAll();
  }

  @GetMapping("/{id}")
  public Mono<User> getUserById(@PathVariable String id){
    return userRepository.findById(id);
  }

  @DeleteMapping("/{id}")
  public Mono<Void> deleteUser(@PathVariable String id){
    return userRepository.deleteById(id);
  }
}
