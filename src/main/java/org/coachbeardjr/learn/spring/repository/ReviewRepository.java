package org.coachbeardjr.learn.spring.repository;

import org.coachbeardjr.learn.spring.data.Review;
import org.springframework.data.mongodb.repository.MongoRepository;

public interface ReviewRepository extends MongoRepository<Review, String> {
  
}
