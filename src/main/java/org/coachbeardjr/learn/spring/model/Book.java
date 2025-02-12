package org.coachbeardjr.learn.spring.model;

import java.util.List;

import org.springframework.data.relational.core.mapping.Table;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;
import jakarta.persistence.ManyToMany;
import lombok.Getter;
import lombok.Setter;

@Entity
@Table("books")
@Getter
@Setter
public class Book{
  @Id @GeneratedValue
  private Long id;
  private String title;
  private String isbn;
  @ManyToMany
  private List<Author> authors;
}