package com.hello.core.scan.filter;

import org.junit.jupiter.api.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.FilterType;

public class ComponentFilterAppConfigTest {

    @Test
    public void filterScan(){
        ApplicationContext ac = new AnnotationConfigApplicationContext(ComponentFilterAppConfig.class);
        BeanA beanA = ac.getBean(BeanA.class);
        System.out.println(beanA);
    }

    @Configuration
    @ComponentScan(
        includeFilters = @ComponentScan.Filter(type = FilterType.ANNOTATION, classes= MyIncludeComponent.class),
        excludeFilters = @ComponentScan.Filter(type = FilterType.ANNOTATION, classes= MyExcludeComponent.class)

    )
    static class ComponentFilterAppConfig {
    }
    
}
