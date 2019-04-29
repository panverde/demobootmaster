package com.joaquin.service;

import com.joaquin.dto.response.ListClassResponse;

import com.joaquin.model.Classes;

import java.util.List;

public interface IClassService extends Crud<Classes> {

  List<ListClassResponse> findAllClassStudent(Integer id);
}
