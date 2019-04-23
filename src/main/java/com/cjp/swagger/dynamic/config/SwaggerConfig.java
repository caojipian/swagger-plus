package com.cjp.swagger.dynamic.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Import;
import org.springframework.core.Ordered;
import org.springframework.core.annotation.Order;
import org.springframework.core.env.Environment;
import org.springframework.web.servlet.HandlerMapping;
import com.cjp.swagger.dynamic.controller.Swagger2Controller;
import com.cjp.swagger.dynamic.source.Source;
import springfox.documentation.spring.web.DocumentationCache;
import springfox.documentation.spring.web.PropertySourcedRequestMappingHandlerMapping;
import springfox.documentation.spring.web.SpringfoxWebMvcConfiguration;
import springfox.documentation.spring.web.json.JacksonModuleRegistrar;
import springfox.documentation.spring.web.json.JsonSerializer;
import springfox.documentation.swagger.configuration.SwaggerCommonConfiguration;
import springfox.documentation.swagger2.configuration.Swagger2JacksonModule;
import springfox.documentation.swagger2.mappers.ServiceModelToSwagger2Mapper;

@Configuration
@Import({ SpringfoxWebMvcConfiguration.class, SwaggerCommonConfiguration.class })
@ComponentScan(basePackages = {
    "springfox.documentation.swagger2.mappers"
})
@Order(Ordered.HIGHEST_PRECEDENCE + 20)
public class SwaggerConfig {
  @Bean
  public JacksonModuleRegistrar swagger2Module() {
    return new Swagger2JacksonModule();
  }

  @Bean
  public HandlerMapping swagger2ControllerMapping(
      Environment environment,
      DocumentationCache documentationCache,
      ServiceModelToSwagger2Mapper mapper,
      JsonSerializer jsonSerializer,Source source) {
    return new PropertySourcedRequestMappingHandlerMapping(
        environment,
        new Swagger2Controller(environment, documentationCache,
            mapper, jsonSerializer,source));
  }
}
