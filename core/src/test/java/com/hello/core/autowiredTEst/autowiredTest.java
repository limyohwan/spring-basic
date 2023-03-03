package com.hello.core.autowiredTEst;

import java.util.Optional;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.lang.Nullable;

import com.hello.core.member.Member;

public class autowiredTest {
    
    
    @Test
    public void autowiredOption(){
        ApplicationContext ac = new AnnotationConfigApplicationContext(TestBean.class);


    }

    static class TestBean{

        @Autowired(required = false)
        public void setNoBean1(Member noBean1){
            System.out.println("nobean " + noBean1);
        }

        @Autowired
        public void setNoBean2(@Nullable Member noBean2){
            System.out.println("nobean2 " + noBean2);
        }

        @Autowired
        public void setNoBean3(Optional<Member> noBean3){
            System.out.println("nobean3 " + noBean3);
        }
    }
}
