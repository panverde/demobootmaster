package com.joaquin.model;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

import lombok.Data;

@Data
@Entity
@Table(name = "students")
public class Students {
  @Id
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  @Column(name = "student_id")
  private Integer studentId;
  @Column(name = "gender", length = 20, nullable = false)
  private String gender;
  @Column(name = "first_name", length = 50, nullable = false)
  private String firstName;
  @Column(name = "middle_name", length = 50, nullable = false)
  private String middleName;
  @Column(name = "last_name", length = 50, nullable = false)
  private String lastName;
  @Column(name = "date_of_birth", length = 50, nullable = false)
  private Date dateOfBirth;
  @Column(name = "other_student_details", length = 150, nullable = true)
  private String otherStudentDetails;


  public Students() {
  }

  /**
   * Constructor Students javadoc joaquin.com
   */
}
