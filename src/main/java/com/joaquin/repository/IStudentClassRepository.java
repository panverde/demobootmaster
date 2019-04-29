package com.joaquin.repository;

import com.joaquin.model.StudentClass;
import com.joaquin.model.StudentClassPk;
import java.util.List;

import javax.transaction.Transactional;
import org.springframework.data.jpa.repository.JpaRepository;

import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;


public interface IStudentClassRepository extends JpaRepository<StudentClass, StudentClassPk> {

  @Modifying
  @Transactional
  void deleteStudentClassByPrimaryKeyClassIdId(Integer id);

  @Modifying
  @Transactional
  @Query(value = "SELECT * FROM student_class a WHERE a.class_id = ?1", nativeQuery = true)
  List<StudentClass> getListStudentClassByClassId(Integer classId);

}
