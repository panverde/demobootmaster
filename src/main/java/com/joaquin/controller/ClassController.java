package com.joaquin.controller;

import com.joaquin.config.Translator;
import com.joaquin.config.validate.ValidateException;

import com.joaquin.dto.response.ListClassResponse;
import com.joaquin.model.Classes;
import com.joaquin.service.impl.ClassServiceImpl;

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
@RequestMapping("/class")
@Api(value = "ClassController")
public class ClassController {

  @Autowired
  private ClassServiceImpl classService;

  /**
   * Controller Class show the list of registered classes javadoc joaquin.com
   */

  @ApiOperation(value = "See the list of all class.")
  @GetMapping(value = "/")
  public List<Classes> listAllClass() {
    return classService.findAll();
  }

  /**
   * Controller Class show list of students enrolled in the same class
   * javadoc joaquin.com
   */

  @ApiOperation(value = "See list of students in a class.")
  @GetMapping(value = "/list/{classId}")
  public List<ListClassResponse> listClassStudent(@PathVariable("classId") Integer id) {
    return classService.findAllClassStudent(id);
  }

  /**
   * Controller Class create javadoc joaquin.com
   */

  @ApiOperation(value = "create a new class.")
  @PostMapping(value = "/")
  public void createClass(@RequestBody @Validated Classes classes, BindingResult bindingResult) {

    if (bindingResult.hasErrors()) {
      List<String> errorList = new ArrayList<>();
      for (FieldError e : bindingResult.getFieldErrors()) {
        errorList.add(Translator.toLocale(e.getDefaultMessage()));
      }
      if (!errorList.isEmpty()) {
        throw new ValidateException(errorList);
      }
    }
    classService.create(classes);
  }

  /**
   * Controller Class update javadoc joaquin.com
   */

  @ApiOperation(value = "update class information.")
  @PutMapping(path = "/{classId}")
  public void updateExistClass(@RequestBody Classes classes, @PathVariable Integer classId) {
    classes.setId(classId);
    classService.update(classes, classId);
  }

  /**
   * Controller Class delete javadoc joaquin.com
   */

  @ApiOperation(value = "delete existing class.")
  @DeleteMapping("/{classId}")
  public void deleteClass(@PathVariable("classId") Integer id) {

    classService.delete(id);

  }


}
