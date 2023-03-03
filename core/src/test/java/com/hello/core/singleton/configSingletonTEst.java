package com.hello.core.singleton;

import org.junit.jupiter.api.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import com.hello.core.AppConfig;
import com.hello.core.member.MemberRepository;
import com.hello.core.member.MemberServiceImpl;
import com.hello.core.order.OrderServiceImpl;

public class configSingletonTEst {

    @Test
    public void configurateionTEst(){
        ApplicationContext ac = new AnnotationConfigApplicationContext(AppConfig.class);

        MemberServiceImpl memberServiceImpl = ac.getBean(MemberServiceImpl.class);
        OrderServiceImpl orderServiceImpl = ac.getBean(OrderServiceImpl.class);

        MemberRepository memberRepository1 = memberServiceImpl.getMemberRepository();
        MemberRepository memberRepository2 = orderServiceImpl.getMemberRepository();
        MemberRepository memberRepo = ac.getBean("memberRepository", MemberRepository.class);
        System.out.println(memberServiceImpl.getClass());
        System.out.println(memberRepository1);
        System.out.println(memberRepository2);
        System.out.println(memberRepo);
    }
    
    @Test
    public void configBean(){
        ApplicationContext ac = new AnnotationConfigApplicationContext(AppConfig.class);
        AppConfig bean = ac.getBean(AppConfig.class);

        System.out.println(bean.getClass());
    }
}
