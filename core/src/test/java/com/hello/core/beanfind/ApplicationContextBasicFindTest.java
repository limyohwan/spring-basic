package com.hello.core.beanfind;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.NoSuchBeanDefinitionException;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import com.hello.core.AppConfig;
import com.hello.core.member.MemberService;
import com.hello.core.member.MemberServiceImpl;

public class ApplicationContextBasicFindTest {
    AnnotationConfigApplicationContext ac =new AnnotationConfigApplicationContext(AppConfig.class);
    
    @Test
    public void findBeanByNAme(){
        MemberService memberService = ac.getBean("memberService", MemberService.class);

        System.out.println(memberService);
        Assertions.assertThat(memberService).isInstanceOf(MemberServiceImpl.class);
    }

    @Test
    public void findBeanBytype(){
        MemberService memberService = ac.getBean(MemberService.class);

        System.out.println(memberService);
        Assertions.assertThat(memberService).isInstanceOf(MemberServiceImpl.class);
    }

    @Test
    public void findBeanBytype2(){
        MemberService memberService = ac.getBean("memberService", MemberServiceImpl.class);

        System.out.println(memberService);
        Assertions.assertThat(memberService).isInstanceOf(MemberServiceImpl.class);
    }

    @Test
    public void findBeanByNAmeX(){
        // MemberService xxxx = ac.getBean("xxxx", MemberService.class);
    
        org.junit.jupiter.api.Assertions.assertThrows(NoSuchBeanDefinitionException.class, () -> ac.getBean("xxxx", MemberService.class));
    }

}
