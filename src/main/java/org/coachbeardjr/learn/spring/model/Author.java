package org.coachbeardjr.learn.spring.model;

import org.springframework.data.relational.core.mapping.Table;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;
import jakarta.persistence.ManyToOne;
import lombok.Getter;
import lombok.Setter;

@Entity
@Table("authors")
@Getter
@Setter
public class Author {
  @Id @GeneratedValue
  private Long id;
  private String name;
  private String biography;
  @ManyToOne
  private Publisher publisher;
}
