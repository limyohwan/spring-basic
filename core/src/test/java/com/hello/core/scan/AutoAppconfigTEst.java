package com.hello.core.scan;

import org.junit.jupiter.api.Test;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import com.hello.core.AutoAppConfig;
import com.hello.core.member.MemberService;

public class AutoAppconfigTEst {
    
    @Test
    public void basicScan(){
        AnnotationConfigApplicationContext ac = new AnnotationConfigApplicationContext(AutoAppConfig.class);

        MemberService memberService = ac.getBean(MemberService.class);
    }
}
