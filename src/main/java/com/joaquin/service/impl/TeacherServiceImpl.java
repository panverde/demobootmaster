package com.joaquin.service.impl;

import com.joaquin.model.Teacher;

import com.joaquin.repository.IClassRepository;

import com.joaquin.repository.ITeacherRepository;

import com.joaquin.service.ITeacherService;

import java.util.List;
import java.util.Optional;
import lombok.extern.slf4j.Slf4j;

import org.springframework.beans.factory.annotation.Autowired;

import org.springframework.stereotype.Service;

@Slf4j
@Service
public class TeacherServiceImpl implements ITeacherService {

  @Autowired
  private ITeacherRepository repositoryTeacher;

  @Autowired
  private IClassRepository repositoryClass;

  @Override
  public List<Teacher> findAll() {
    return repositoryTeacher.findAll();
  }

  @Override
  public Teacher create(Teacher obj) {
    return repositoryTeacher.save(obj);
  }

  /**
   * This method is responsible for updating the records of a teacher.
   * @author joaquin.com
   * @param id represents the idTeacher of type integer.
   */

  @Override
  public void update(Teacher obj, Integer id) {

    Optional<Teacher> teacherOptional = repositoryTeacher.findById(id);
    if (teacherOptional.isPresent()) {
      Teacher teacherBase = teacherOptional.get();

      teacherBase.setFirstName(obj.getFirstName());
      teacherBase.setGender(obj.getGender());
      teacherBase.setLastName(obj.getLastName());
      teacherBase.setMiddleName(obj.getMiddleName());
      teacherBase.setOtherTeacherDetails(obj.getOtherTeacherDetails());

      repositoryTeacher.save(teacherBase);

      log.info("Update successful");

    } else {
      log.warn("Not found ID");
    }

  }

  /**
   * This this method is responsible for deleting a record of the teacher table and
   * its forename in the class table.
   * @author joaquin.com
   * @param id represents the idTeacher of type integer.
   */

  @Override
  public void delete(Integer id) {
    Optional<Teacher> teacherOptional = repositoryTeacher.findById(id);

    if (teacherOptional.isPresent()) {
      repositoryClass.deleteClassbyTeacherId(id);
      repositoryTeacher.deleteById(id);
    } else {
      log.warn("Not found ID");
    }

  }

}
