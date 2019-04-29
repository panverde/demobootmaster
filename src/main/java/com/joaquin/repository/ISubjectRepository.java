package com.joaquin.repository;

import com.joaquin.model.Subject;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ISubjectRepository extends JpaRepository<Subject, Integer> {

}
