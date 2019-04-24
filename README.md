## Introduction
swagger-plus 是对swagger进行增强的工具包，其设计目标是使其更贴近与实际工作中，初版主要是实现了可动态开关swagger，初次开源，也欢迎喜欢开源的同学提上自己宝贵的意见。

## 使用方式
#### 保持swagger本身的配置不变，新增Source的注册

```Java
import com.cjp.swagger.dynamic.annotation.EnableSwagger;
import com.cjp.swagger.dynamic.source.Source;
import ...;

@Configuration
//注意！这里需要把swagger本身的enable注解改成swagger-plus提供的注解
@EnableSwagger
public class SwaggerConfig{
  //swagger本身配置
  @Bean
  public Docket docket() {
    Docket docket =new Docket...
    return docket;
  }
  //swagger-plus新增的配置
  @Bean
  public Source source() {
    return new Source() {
      public boolean isOpen() {
        //以下以apollo为例，使用者可使用其它数据源
        return ConfigService.getAppConfig().getBooleanProperty("swagger.switch", true);
      }
    };
  }
}
```
#### pom.xml文件中加入依赖
```Xml
<dependency>
		<groupId>com.cjp.framework</groupId>
		<artifactId>swagger-plus</artifactId>
		<version>1.0</version>
</dependency>
