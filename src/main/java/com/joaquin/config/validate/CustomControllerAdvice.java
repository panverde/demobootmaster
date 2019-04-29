package com.joaquin.config.validate;

import java.util.List;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.ResponseStatus;

@Slf4j
@ControllerAdvice
public class CustomControllerAdvice {

  /**
   * CustomException  javadoc joaquin.com
   */

  @ExceptionHandler(CustomException.class)
  @ResponseStatus(HttpStatus.CONFLICT)
  @ResponseBody
  public String handleMyException(CustomException ex) {

    log.info("Error!! : " + ex);
    return "Error controlado";
  }

  /**
   * ValidateException  javadoc joaquin.com
   */

  @ExceptionHandler(ValidateException.class)
  @ResponseStatus(HttpStatus.BAD_REQUEST)
  @ResponseBody
  public List<String> handleMyException2(ValidateException ex) {

    log.info("Error de validacion!! : " + ex);

    return ex.getErrMsg();
  }

}
