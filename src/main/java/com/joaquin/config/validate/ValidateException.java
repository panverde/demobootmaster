package com.joaquin.config.validate;

import java.util.List;

import lombok.Data;

@Data
public class ValidateException extends RuntimeException {

  private List<String> errMsg;

  public ValidateException(List<String> errMsg) {
    this.errMsg = errMsg;
  }
}
