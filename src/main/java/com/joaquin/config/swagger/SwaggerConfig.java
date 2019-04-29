package com.joaquin.config.swagger;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.bind.annotation.RequestMethod;

import springfox.documentation.builders.PathSelectors;
import springfox.documentation.builders.RequestHandlerSelectors;
import springfox.documentation.builders.ResponseMessageBuilder;
import springfox.documentation.service.ResponseMessage;
import springfox.documentation.spi.DocumentationType;
import springfox.documentation.spring.web.plugins.Docket;
import springfox.documentation.swagger2.annotations.EnableSwagger2;

@Configuration
@EnableSwagger2
public class SwaggerConfig {

  @Value("${swagger.message.error500}")
  private String error500;
  @Value("${swagger.message.error403}")
  private String error403;
  @Value("${swagger.message.error401}")
  private String error401;
  @Value("${swagger.message.error404}")
  private String error404;
  @Value("${swagger.message.basePackageApi}")
  private String basePackageApi;

  /**
   *swagger message configuration and base package javadoc joaquin.com
   */

  @Bean
  public Docket api() {

    final List<ResponseMessage> responseMessageList = new ArrayList<ResponseMessage>();
    responseMessageList
            .add(new ResponseMessageBuilder().code(500).message(error500).build());
    responseMessageList.add(new ResponseMessageBuilder().code(403).message(error403)
            .build());
    responseMessageList.add(new ResponseMessageBuilder().code(401).message(error401)
            .build());
    responseMessageList.add(new ResponseMessageBuilder().code(404).message(error404)
            .build());

    return new Docket(DocumentationType.SWAGGER_2)
            .select()
            .apis(RequestHandlerSelectors.basePackage(basePackageApi))
            .paths(PathSelectors.any())
            .build().useDefaultResponseMessages(false)
            .globalResponseMessage(RequestMethod.GET, responseMessageList);


  }

}
