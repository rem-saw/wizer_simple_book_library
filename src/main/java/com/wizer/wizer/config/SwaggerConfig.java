package com.wizer.wizer.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import springfox.documentation.builders.PathSelectors;
import springfox.documentation.builders.RequestHandlerSelectors;
import springfox.documentation.service.ApiInfo;
import springfox.documentation.service.Contact;
import springfox.documentation.spi.DocumentationType;
import springfox.documentation.spring.web.plugins.Docket;
import static springfox.documentation.builders.PathSelectors.regex;

import springfox.documentation.swagger2.annotations.EnableSwagger2;;

/**
 * @author samuel.sawyerr
 */


@Configuration
//@EnableSwagger2
public class SwaggerConfig {

    @Bean
    public Docket api() {
        return new Docket(DocumentationType.SWAGGER_2)
                .select()
                .apis(RequestHandlerSelectors.any())
                .paths(PathSelectors.any())
                .build();
    }

//    @Bean
//    public Docket productApi() {
//        return new Docket(DocumentationType.SWAGGER_2)
//                .select()
////                .apis(RequestHandlerSelectors.basePackage("com.wizer.wizer"))
////                .paths(regex("/wizer.*"))
//                .build();
//               // .apiInfo(metaInfo());
//    }



    private ApiInfo metaInfo() {



//        ApiInfo apiInfo = new ApiInfo(
//                "Wizer Code Challenge",
//                "Wizer Simple Library Project ahead of interview",
//                "1.0",
//                "Terms of Service",
//                new Contact("Samuel Sawyerr", "https://www.linkedin.com/in/samuel-remilekun-sawyerr-45540ab3/",
//                        "remsaw4christ@gmail.com"),
//                "Apache License Version 2.0",
//                "https://www.apache.org/licesen.html"
//        );
        ApiInfo apiInfo = ApiInfo.DEFAULT;
        return ApiInfo.DEFAULT;
    }
}
