package com.joaquin.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.validation.constraints.NotEmpty;

import lombok.Data;

@Data
@Entity
@Table(name = "subject")
public class Subject {

  @Id
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  @Column(name = "subjectId")
  private Integer id;
  @NotEmpty(message = "subject-empty")
  @Column(name = "subjectName", length = 50, nullable = false)
  private String subjectName;
}
