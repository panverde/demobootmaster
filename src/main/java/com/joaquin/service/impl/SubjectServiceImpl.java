package com.joaquin.service.impl;

import com.joaquin.model.Subject;

import com.joaquin.repository.IClassRepository;
import com.joaquin.repository.ISubjectRepository;
import com.joaquin.service.ISubjectService;

import java.util.List;
import java.util.Optional;
import lombok.extern.slf4j.Slf4j;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Slf4j
@Service
public class SubjectServiceImpl implements ISubjectService {

  @Autowired
  private ISubjectRepository repositorySubject;

  @Autowired
  private IClassRepository repositoryClass;

  @Override
  public List<Subject> findAll() {
    return repositorySubject.findAll();
  }

  @Override
  public Subject create(Subject obj) {
    return repositorySubject.save(obj);
  }

  @Override
  public void update(Subject obj, Integer id) {

    Optional<Subject> subjectOptional = repositorySubject.findById(id);
    if (subjectOptional.isPresent()) {
      Subject subjectBase = subjectOptional.get();

      subjectBase.setSubjectName(obj.getSubjectName());

      repositorySubject.save(subjectBase);

      log.info("Update successful");

    } else {
      log.warn("Not found ID");
    }

  }

  @Override
  public void delete(Integer id) {

    Optional<Subject> subjectOptional = repositorySubject.findById(id);
    if (subjectOptional.isPresent()) {
      repositoryClass.deleteClassbySubjectId(id);
      repositorySubject.deleteById(id);
      log.info("Delete successful");

    } else {
      log.warn("Not found ID");
    }

  }

}
