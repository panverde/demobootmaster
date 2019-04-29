package com.joaquin.config.validate;

import lombok.Data;
import lombok.ToString;

@ToString
@Data
public class CustomException extends RuntimeException {

  private String errCode;
  private String errMsg;

  public CustomException() { }

  public CustomException(String errCode, String errMsg) {
    this.errCode = errCode;
    this.errMsg = errMsg;
  }

}
