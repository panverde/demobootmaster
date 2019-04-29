package com.joaquin.controller;

import com.joaquin.model.StudentClass;
import com.joaquin.service.impl.StudentClassServiceImpl;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;

import java.util.List;
import lombok.extern.slf4j.Slf4j;

import org.springframework.beans.factory.annotation.Autowired;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@Slf4j
@RestController
@RequestMapping("/studentclass")
@Api(value = "StudentClassController")
public class StudentClassController {

  @Autowired
  private StudentClassServiceImpl serviceStudenClass;

  @ApiOperation(value = "See the list of all studentClass.")
  @GetMapping(value = "/")
  public List<StudentClass> listAllStudentClass() {
    return serviceStudenClass.findAll();
  }

  /**
   * Controller StudentClass create javadoc joaquin.com
   */

  @ApiOperation(value = "create a new studentClass.")
  @PostMapping(value = "/")
  public void createStudentClass(@RequestBody StudentClass studentClass) {
    try {
      serviceStudenClass.create(studentClass);
      log.info("StudentClass Create");
    } catch (Exception e) {
      log.error("StudentClass create error" + e);
    }
  }
}
