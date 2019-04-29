package com.joaquin.controller;

import com.joaquin.config.Translator;
import com.joaquin.config.validate.ValidateException;

import com.joaquin.model.Teacher;
import com.joaquin.service.impl.TeacherServiceImpl;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;

import java.util.ArrayList;
import java.util.List;
import lombok.extern.slf4j.Slf4j;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.validation.BindingResult;
import org.springframework.validation.FieldError;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@Slf4j
@RestController
@RequestMapping("/teacher")
@Api(value = "TeacherController")
public class TeacherController {

  @Autowired
  private TeacherServiceImpl teacherService;

  @ApiOperation(value = "See the list of all teacher")
  @GetMapping(value = "/")
  public List<Teacher> listAllTeacher() {
    return teacherService.findAll();
  }

  /**
   * Controller Teacher create javadoc joaquin.com
   */

  @ApiOperation(value = "create a new teacher.")
  @PostMapping(value = "/")
  public void createTeacher(@RequestBody @Validated Teacher teacher, BindingResult bindingResult) {
    if (bindingResult.hasErrors()) {
      List<String> errorList = new ArrayList<>();
      for (FieldError e : bindingResult.getFieldErrors()) {
        errorList.add(Translator.toLocale(e.getDefaultMessage()));
      }
      if (!errorList.isEmpty()) {
        throw new ValidateException(errorList);
      }
    }

    teacherService.create(teacher);

  }

  /**
   * Controller Teacher update javadoc joaquin.com
   */

  @ApiOperation(value = "update teacher information.")
  @PutMapping(path = "/{teacherId}")
  public void updateExistTeacher(@RequestBody Teacher teacher, @PathVariable Integer teacherId) {

    teacher.setId(teacherId);
    teacherService.update(teacher, teacherId);

  }

  /**
   * Controller Teacher delete javadoc joaquin.com
   */

  @ApiOperation(value = "delete existing teacher.")
  @DeleteMapping("/{teacherId}")
  public void deleteTeacher(@PathVariable("teacherId") Integer id) {
    try {
      teacherService.delete(id);
      log.info("delete teacher id :" + id);
    } catch (Exception e) {
      log.error("Teacher delete error" + e);
    }
  }

}
