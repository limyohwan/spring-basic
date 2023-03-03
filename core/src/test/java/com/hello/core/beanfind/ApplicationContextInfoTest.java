package com.hello.core.beanfind;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.config.BeanDefinition;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import com.hello.core.AppConfig;

public class ApplicationContextInfoTest {
    AnnotationConfigApplicationContext ac =new AnnotationConfigApplicationContext(AppConfig.class);

    @Test
    public void findAllBean(){
        String[] beanDefinitionNames = ac.getBeanDefinitionNames();

        for(String bdn : beanDefinitionNames){
            Object bean = ac.getBean(bdn);
            System.out.println(bdn);
            System.out.println(bean);
        }
    }

    @Test
    public void findApplicationBean(){
        String[] beanDefinitionNames = ac.getBeanDefinitionNames();

        for(String bdn : beanDefinitionNames){
            BeanDefinition bean = ac.getBeanDefinition(bdn);
     
            if(bean.getRole() == BeanDefinition.ROLE_APPLICATION){
                System.out.println(bdn);
            }
        }
    }
}
