package com.joaquin.model;

import java.util.Date;

import javax.persistence.EmbeddedId;
import javax.persistence.Entity;
import javax.persistence.Table;
import lombok.Data;

@Data
@Entity
@Table(name = "student_class")
public class StudentClass {

  @EmbeddedId
  private StudentClassPk primaryKey;
  
  private Date dateTo;
  

}
