package com.joaquin.service.impl;

import com.joaquin.dto.response.ListClassResponse;
import com.joaquin.model.Classes;
import com.joaquin.model.StudentClass;
import com.joaquin.model.Students;
import com.joaquin.repository.IClassRepository;
import com.joaquin.repository.IStudentClassRepository;
import com.joaquin.service.IClassService;
import com.joaquin.service.IStudentService;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import lombok.extern.slf4j.Slf4j;

import org.springframework.beans.factory.annotation.Autowired;

import org.springframework.stereotype.Service;

@Slf4j
@Service
public class ClassServiceImpl implements IClassService {

  @Autowired
  private IClassRepository repositoryClass;

  @Autowired
  private IStudentService repositoryStudent;

  @Autowired
  private IStudentClassRepository repositoryStudentClass;

  @Override
  public List<Classes> findAll() {
    return repositoryClass.findAll();
  }

  @Override
  public Classes create(Classes obj) {
    return repositoryClass.save(obj);
  }

  @Override
  public void update(Classes obj, Integer id) {

    Optional<Classes> classOptional = repositoryClass.findById(id);
    if (classOptional.isPresent()) {
      Classes classBase = classOptional.get();

      classBase.setSubjectId(obj.getSubjectId());
      classBase.setTeacherId(obj.getTeacherId());
      classBase.setClassCode(obj.getClassCode());
      classBase.setClassName(obj.getClassName());
      classBase.setDateFrom(obj.getDateFrom());
      classBase.setDateTo(obj.getDateTo());

      repositoryClass.save(classBase);

      log.info("Update successful");

    } else {
      log.warn("Not found ID");
    }

  }

  @Override
  public void delete(Integer id) {

    repositoryStudentClass.deleteStudentClassByPrimaryKeyClassIdId(id);
    repositoryClass.deleteById(id);

  }

  @Override
  public List<ListClassResponse> findAllClassStudent(Integer id) {

    List<StudentClass> listStudentClass = repositoryStudentClass.getListStudentClassByClassId(id);

    List<ListClassResponse> listClassResponses = null;

    if (listStudentClass != null && !listStudentClass.isEmpty()) {


      ListClassResponse lstClassResponse = null;

      List<ListClassResponse.StudentListResponse> lstStudentNew = new ArrayList<>();
      for (StudentClass studentClass : listStudentClass) {
        listClassResponses = new ArrayList<ListClassResponse>();
        lstClassResponse = new ListClassResponse();
        lstClassResponse.setClassName(studentClass.getPrimaryKey().getClassId().getClassName());
        lstClassResponse.setClassCode(studentClass.getPrimaryKey().getClassId().getClassCode());
        lstClassResponse.setDateFrom(studentClass.getPrimaryKey().getClassId().getDateFrom());
        lstClassResponse.setDateTo(studentClass.getDateTo());

        List<Students> listStudents = repositoryStudent.findAll();

        for (Students student : listStudents) {
          ListClassResponse.StudentListResponse studenta =
                  new ListClassResponse.StudentListResponse();
          if (studentClass.getPrimaryKey().getStudent_id().getStudentId()
                  == student.getStudentId()) {
            studenta.setStudentId(student.getStudentId());
            studenta.setFirstName(student.getFirstName());
            studenta.setMiddleName(student.getMiddleName());
            studenta.setLastName(student.getLastName());
            studenta.setDateOfBirth(student.getDateOfBirth());
            studenta.setOtherStudentDetails(student.getOtherStudentDetails());
            lstStudentNew.add(studenta);

          }


          lstClassResponse.setStudents(lstStudentNew);

        }


        listClassResponses.add(lstClassResponse);
      }

    }

    return listClassResponses;
  }

}
