package com.hello.core.singleton;

import org.junit.jupiter.api.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.annotation.Bean;

import com.hello.core.AppConfig;
import com.hello.core.member.MemberService;

public class SingletonTest {
    
    @Test
    public void pureContainer(){
        
        AppConfig appConfig = new AppConfig();

        MemberService memberService1 = appConfig.memberService();
        MemberService memberService2 = appConfig.memberService();

        System.out.println(memberService1);
        System.out.println(memberService2);
    }

    @Test
    public void singletonSErviceTEst(){
        SingletonService singletonService1 = SingletonService.getInstance();
        SingletonService singletonService2 = SingletonService.getInstance();

        System.out.println(singletonService1);
        System.out.println(singletonService2);
    }

    @Test
    public void spirngContainer(){
        ApplicationContext ac = new AnnotationConfigApplicationContext(AppConfig.class);

        MemberService memberService1 = ac.getBean(MemberService.class);
        MemberService memberService2 = ac.getBean(MemberService.class);

        System.out.println(memberService1);
        System.out.println(memberService2);
    }

    @Test
    public void statfueserivceSingleton(){
        ApplicationContext ac = new AnnotationConfigApplicationContext(TestConfig.class);
        StatefulService statefulService1 = ac.getBean(StatefulService.class);
        StatefulService statefulService2 = ac.getBean(StatefulService.class);

        statefulService2.order("userB", 20000);

        System.out.println(statefulService1.order("userA", 10000));
    }

    static class TestConfig{
        @Bean
        public StatefulService statefulService(){
            return new StatefulService();
        }
    }

}
