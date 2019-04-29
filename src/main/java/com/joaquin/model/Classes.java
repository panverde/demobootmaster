package com.joaquin.model;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import javax.validation.constraints.NotEmpty;

import lombok.Data;

@Data
@Entity
@Table(name = "class")
public class Classes {
  @Id
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  @Column(name = "classId")
  private Integer id;
  @NotEmpty(message = "class-classCode-notEmpty")
  @Column(name = "classCode", length = 50, nullable = false)
  private String classCode;
  @NotEmpty(message = "class-className-notEmpty")
  @Column(name = "className", length = 50, nullable = false)
  private String className;
  @Column(name = "dateFrom", nullable = false)
  private Date dateFrom;
  @Column(name = "dateTo", length = 50, nullable = false)
  private Date dateTo;
  @ManyToOne()
  @JoinColumn(name = "subjectId")
  private Subject subjectId;
  @ManyToOne()
  @JoinColumn(name = "teacherId")
  private Teacher teacherId;
}
