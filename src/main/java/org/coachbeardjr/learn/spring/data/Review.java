package org.coachbeardjr.learn.spring.data;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Document(collation = "reviews")
public class Review {
  @Id
  private String id;
  private Long bookId;
  private String reviewerName;
  private String comment;
  private int rating;
}
