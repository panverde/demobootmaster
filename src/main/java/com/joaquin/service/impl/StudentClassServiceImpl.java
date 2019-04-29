package com.joaquin.service.impl;

import com.joaquin.model.StudentClass;
import com.joaquin.repository.IStudentClassRepository;
import com.joaquin.service.IStudentClassService;

import java.util.List;

import lombok.extern.slf4j.Slf4j;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Slf4j
@Service
public class StudentClassServiceImpl implements IStudentClassService {

  @Autowired
  private IStudentClassRepository repositoryStudentClass;

  @Override
  public List<StudentClass> findAll() {
    return repositoryStudentClass.findAll();
  }

  @Override
  public StudentClass create(StudentClass obj) {

    return repositoryStudentClass.save(obj);
  }

  @Override
  public void update(StudentClass obj, Integer id) {
    // TODO Auto-generated method stub
  }

  @Override
  public void delete(Integer id) {
    // TODO Auto-generated method stub
  }

}
