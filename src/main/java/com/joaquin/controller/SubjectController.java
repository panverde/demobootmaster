package com.joaquin.controller;

import com.joaquin.config.Translator;
import com.joaquin.config.validate.ValidateException;

import com.joaquin.model.Subject;
import com.joaquin.service.impl.SubjectServiceImpl;

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
@RequestMapping("/subject")
@Api(value = "SubjectController")
public class SubjectController {

  @Autowired
  private SubjectServiceImpl subjectService;

  @ApiOperation(value = "See the list of all subject")
  @GetMapping(value = "/")
  public List<Subject> listAllSubject() {
    return subjectService.findAll();
  }

  /**
   * Controller Subject create javadoc joaquin.com
   */

  @ApiOperation(value = "create a new subject.")
  @PostMapping(value = "/")
  public void createSubject(@RequestBody @Validated Subject subject, BindingResult bindingResult) {

    if (bindingResult.hasErrors()) {
      List<String> errorList = new ArrayList<>();
      for (FieldError e : bindingResult.getFieldErrors()) {
        errorList.add(Translator.toLocale(e.getDefaultMessage()));
      }
      if (!errorList.isEmpty()) {
        throw new ValidateException(errorList);
      }
    }
    try {
      subjectService.create(subject);
      log.info("Subject create");
    } catch (Exception e) {
      log.error("Subject create error " + e);
    }
  }

  /**
   * Controller Subject update javadoc joaquin.com
   */

  @ApiOperation(value = "update subject information.")
  @PutMapping(path = "/{subjectId}")
  public void updateExistSubject(@RequestBody Subject subject, @PathVariable Integer subjectId) {

    subject.setId(subjectId);
    subjectService.update(subject, subjectId);

  }

  @ApiOperation(value = "delete existing subject.")
  @DeleteMapping("/{subjectId}")
  public void deleteSubject(@PathVariable("subjectId") Integer id) {
    subjectService.delete(id);

  }

}
