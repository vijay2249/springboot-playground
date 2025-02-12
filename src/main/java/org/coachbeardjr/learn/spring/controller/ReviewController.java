package org.coachbeardjr.learn.spring.controller;

import java.util.Optional;

import org.coachbeardjr.learn.spring.data.Review;
import org.coachbeardjr.learn.spring.repository.ReviewRepository;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import lombok.RequiredArgsConstructor;

@RestController
@RequestMapping("/reviews")
@RequiredArgsConstructor
public class ReviewController {
  private final ReviewRepository reviewRepository;

  @PostMapping
  public ResponseEntity<Review> addReview(@RequestBody Review review){
    Review savedReview = reviewRepository.save(review);
    return ResponseEntity.ok(savedReview);
  }

  @GetMapping("/{id}")
  public ResponseEntity<Review> getReview(@PathVariable String id){
    Optional<Review> review = reviewRepository.findById(id);
    return review.map(ResponseEntity::ok).orElseGet(()-> ResponseEntity.notFound().build());
  }
}
