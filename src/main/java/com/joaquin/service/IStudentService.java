package com.joaquin.service;

import com.joaquin.fallback.StudentFallBack;
import com.joaquin.model.Students;

import java.util.List;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

@FeignClient(url = "${client.student.listStudent}", name = "students",
        fallbackFactory = StudentFallBack.class)
public interface IStudentService {

  @GetMapping(value = "/")
  List<Students> findAll();

  @GetMapping(value = "/validate/{studentID}")
  boolean validateStudent(@PathVariable("studentID") Integer id);
}
