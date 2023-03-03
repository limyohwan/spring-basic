package com.hello.core.beanDefinition;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.config.BeanDefinition;
import org.springframework.context.support.GenericXmlApplicationContext;

public class BeanDefinitonTest {

    // AnnotationConfigApplicationContext ac =new AnnotationConfigApplicationContext(AppConfig.class);
    GenericXmlApplicationContext ac = new GenericXmlApplicationContext("appConfig.xml");

    @Test
    public void findAppliBean(){

        String[] bdns = ac.getBeanDefinitionNames();

        for(String bdn: bdns){
            BeanDefinition bd = ac.getBeanDefinition(bdn);

            if(bd.getRole() == BeanDefinition.ROLE_APPLICATION){
                System.out.println(bdn);
                System.out.println(bd);
            }
        }
    }
    
}
