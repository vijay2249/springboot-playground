package org.coachbeardjr.learn.spring.model;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.Getter;
import lombok.Setter;

@Entity
@Table(name="authors")
@Getter
@Setter
public class Author {
  @Id @GeneratedValue
  private Long id;
  private String name;
  private String biography;
}
