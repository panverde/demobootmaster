package com.joaquin.repository;

import com.joaquin.model.Teacher;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ITeacherRepository extends JpaRepository<Teacher, Integer> {

}
