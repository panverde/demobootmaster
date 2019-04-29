package com.joaquin.config.validate;

import lombok.Data;

import java.util.List;

@Data
public class ValidateException extends RuntimeException {

  private List<String> errMsg;

  public ValidateException(List<String> errMsg) {
    this.errMsg = errMsg;
  }
}
