package com.hello.core.beanfind;

import java.util.Map;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.NoUniqueBeanDefinitionException;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import com.hello.core.AppConfig;

import com.hello.core.member.MemberRepository;
import com.hello.core.member.MemoryMemberRepository;

public class ApplicationContextSameBeanTest {
    AnnotationConfigApplicationContext ac =new AnnotationConfigApplicationContext(SameBeanConfig.class);

    @Test
    public void findBeanByTypeDuplt(){
        // MemberRepository bean = ac.getBean(MemberRepository.class);
    
        org.junit.jupiter.api.Assertions.assertThrows(NoUniqueBeanDefinitionException.class, () -> ac.getBean(MemberRepository.class));

    }

    @Test
    public void findBeanByName(){
        MemberRepository bean = ac.getBean("memberRepository1", MemberRepository.class);
        Assertions.assertThat(bean).isInstanceOf(MemberRepository.class);
    }

    @Test
    public void findAllBeanByType(){
        Map<String, MemberRepository> beanOfType = ac.getBeansOfType(MemberRepository.class);
        for(String key : beanOfType.keySet()){
            System.out.println(key);
            System.out.println(beanOfType.get(key));
        }
    }

    @Configuration
    static class SameBeanConfig{
        @Bean
        public MemberRepository memberRepository1(){
            return new MemoryMemberRepository();
        }

        @Bean
        public MemberRepository memberRepository2(){
            return new MemoryMemberRepository();
        }
    }
}
