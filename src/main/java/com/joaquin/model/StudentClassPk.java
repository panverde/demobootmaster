package com.joaquin.model;

import java.io.Serializable;
import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Embeddable;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;

import lombok.Data;

@Data
@Embeddable
public class StudentClassPk implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	@ManyToOne
	@JoinColumn(name = "classId")
	private Classes classId;

	@ManyToOne
	@JoinColumn(name = "student_id")
	private Students student_id;

	@Column(name = "dateFrom")
	private Date dateFrom;

}
