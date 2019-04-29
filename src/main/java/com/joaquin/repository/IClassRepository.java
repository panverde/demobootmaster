package com.joaquin.repository;

import com.joaquin.model.Classes;

import javax.transaction.Transactional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;

public interface IClassRepository extends JpaRepository<Classes, Integer> {
  @Modifying
  @Transactional
  @Query(value = "DELETE FROM class c WHERE c.subject_id=?1", nativeQuery = true)
  void deleteClassbySubjectId(Integer id);

  @Modifying
  @Transactional
  @Query(value = "DELETE FROM class c WHERE c.teacher_id=?1", nativeQuery = true)
  void deleteClassbyTeacherId(Integer id);

}
