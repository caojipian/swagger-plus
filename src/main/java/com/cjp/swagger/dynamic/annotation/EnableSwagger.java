package com.cjp.swagger.dynamic.annotation;

import java.lang.annotation.Documented;
import java.lang.annotation.Retention;
import java.lang.annotation.Target;
import org.springframework.context.annotation.Import;
import com.cjp.swagger.dynamic.config.SwaggerConfig;

/**
 * @author cjp
 */
@Retention(value = java.lang.annotation.RetentionPolicy.RUNTIME)
@Target(value = { java.lang.annotation.ElementType.TYPE })
@Documented
@Import({SwaggerConfig.class})
public @interface EnableSwagger 
{
}
