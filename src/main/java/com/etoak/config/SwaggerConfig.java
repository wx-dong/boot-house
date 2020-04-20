package com.etoak.config;

import io.swagger.annotations.Api;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import springfox.documentation.builders.ApiInfoBuilder;
import springfox.documentation.builders.PathSelectors;
import springfox.documentation.builders.RequestHandlerSelectors;
import springfox.documentation.service.ApiInfo;
import springfox.documentation.spi.DocumentationType;
import springfox.documentation.spring.web.plugins.Docket;
import springfox.documentation.swagger2.annotations.EnableSwagger2;

/**
 * Created by w on 2020/4/20.
 */
@Configuration
@EnableSwagger2
public class SwaggerConfig {

    @Bean
    public Docket doc(){
        ApiInfo apiInfo = new ApiInfoBuilder()
                .title("使用Swagger创建REST风格的api文档").description("随便描述信息")
                .termsOfServiceUrl("http://www.etoak.com")
                .version("V1.0")
                .build();
        return new Docket(DocumentationType.SWAGGER_2)
                .apiInfo(apiInfo).select().paths(PathSelectors.any())
                .apis(RequestHandlerSelectors.basePackage("com.etoak.controller")).build();

    }

}
