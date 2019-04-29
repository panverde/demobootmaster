package com.joaquin.fallback;

import com.joaquin.model.Students;

import com.joaquin.service.IStudentService;

import feign.hystrix.FallbackFactory;

import java.util.ArrayList;
import java.util.List;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Component;

@Component
@Slf4j
public class StudentFallBack implements FallbackFactory<IStudentService> {

  @Override
  public IStudentService create(Throwable cause) {
    return new IStudentService() {

      @Override
      public List<Students> findAll() {
        log.error("error consulting students service");
        Students student = new Students();
        student.setStudentId(0);
        List<Students> listStudent = new ArrayList<>();
        listStudent.add(student);
        return listStudent;
      }

      @Override
      public boolean validateStudent(Integer id) {
        // TODO Auto-generated method stub
        return false;
      }
    };
  }

}
