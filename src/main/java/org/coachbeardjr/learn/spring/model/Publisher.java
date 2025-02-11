package org.coachbeardjr.learn.spring.model;

import org.springframework.data.annotation.Id;
import org.springframework.data.relational.core.mapping.Table;

import jakarta.persistence.Entity;
import lombok.Getter;
import lombok.Setter;

@Entity
@Getter
@Setter
@Table("publishers")
public class Publisher{
  @Id 
  private Long id; 
  private String name; 
  private String address;
}

