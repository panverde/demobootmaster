package com.joaquin.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.Size;

import lombok.Data;

@Data
@Entity
@Table(name = "teacher")
public class Teacher {

  @Id
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  @Column(name = "teacherId")
  private Integer id;
  @NotEmpty(message = "gender-empty")
  @Size(max = 1, message = "gender-size")
  @Column(name = "gender", length = 2, nullable = false)
  private String gender;
  @NotEmpty(message = "teacher-firstName-notEmpty")
  @Column(name = "firstName", length = 50, nullable = false)
  private String firstName;
  @NotEmpty(message = "teacher-middleName-notEmpty")
  @Column(name = "middleName", length = 50, nullable = false)
  private String middleName;
  @NotEmpty(message = "teacher-lastName-notEmpty")
  @Column(name = "lastName", length = 50, nullable = false)
  private String lastName;
  @Size(max = 50, message = "details-size")
  @Column(name = "otherTeacherDetails", length = 50, nullable = false)
  private String otherTeacherDetails;

}
