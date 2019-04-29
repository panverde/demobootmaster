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

  /**
   * This method is responsible for updating the records of a class.
   * @author joaquin.com
   * @param id represents the idClass of type integer.
   */

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

  /**
   * This this method is responsible for deleting a record of the class table and
   * its forename in the studentclass table.
   * @author joaquin.com
   * @param id represents the idClass of type integer.
   */

  @Override
  public void delete(Integer id) {

    Optional<Classes> classOptional = repositoryClass.findById(id);

    if (classOptional.isPresent()) {
      repositoryStudentClass.deleteStudentClassByPrimaryKeyClassIdId(id);
      repositoryClass.deleteById(id);
    } else {
      log.warn("Not found ID");
    }

  }

  /**
   * This method is responsible for bringing the list of students enrolled in the same class.
   * @author joaquin.com
   * @param id represents the idClass of type integer.
   * @return class and list of students.
   */

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
