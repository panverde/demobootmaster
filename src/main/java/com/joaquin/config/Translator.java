package com.joaquin.config;

import java.util.Locale;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.i18n.LocaleContextHolder;
import org.springframework.context.support.ResourceBundleMessageSource;
import org.springframework.stereotype.Component;

@Component
public class Translator {

  private static ResourceBundleMessageSource messageSource;

  @Autowired
  Translator(ResourceBundleMessageSource messageSource) {
    Translator.messageSource = messageSource;
  }

  /**
   * elegir el mensaje correcto de acuerdo con la configuración regional.
   * msgCode consulta los codigos de mensaje en messages.properties
   */

  public static String toLocale(String msgCode) {
    Locale locale = LocaleContextHolder.getLocale();
    return messageSource.getMessage(msgCode, null, msgCode, locale);
  }
}
