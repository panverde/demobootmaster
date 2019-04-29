package com.joaquin.dto.response;

import java.util.Date;
import java.util.List;

import lombok.Data;

@Data
public class ListClassResponse {

  private String classCode;

  private String className;

  private Date dateFrom;

  private Date dateTo;

  private List<StudentListResponse> Students;

  @Data
  public static class StudentListResponse {

    private Integer studentId;
    private String firstName;
    private String middleName;
    private String lastName;
    private Date dateOfBirth;
    private String otherStudentDetails;

  }

}
