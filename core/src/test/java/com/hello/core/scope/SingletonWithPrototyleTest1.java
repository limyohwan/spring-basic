package com.hello.core.scope;

import javax.annotation.PostConstruct;
import javax.annotation.PreDestroy;
import javax.inject.Provider;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.ObjectProvider;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.annotation.Scope;

public class SingletonWithPrototyleTest1 {
    
    @Test
    public void prototypefind(){
        AnnotationConfigApplicationContext ac = new AnnotationConfigApplicationContext(PrototypeBean.class);

        PrototypeBean prototypeBean1 = ac.getBean(PrototypeBean.class);
        prototypeBean1.addCount();
        Assertions.assertThat(prototypeBean1.getCount()).isEqualTo(1);
        System.out.println(prototypeBean1);

        PrototypeBean prototypeBean2 = ac.getBean(PrototypeBean.class);
        prototypeBean2.addCount();
        Assertions.assertThat(prototypeBean2.getCount()).isEqualTo(1);
        System.out.println(prototypeBean2);

    }

    @Test
    public void singletonClientUserprototype(){
        AnnotationConfigApplicationContext ac = new AnnotationConfigApplicationContext(ClientBean.class,PrototypeBean.class);

        ClientBean clientBean1 = ac.getBean(ClientBean.class);
        Assertions.assertThat(clientBean1.logic()).isEqualTo(1);
        

        ClientBean clientBean2 = ac.getBean(ClientBean.class);
        Assertions.assertThat(clientBean2.logic()).isEqualTo(1);


    }

    @Scope("singleton")
    static class ClientBean{
        // private final PrototypeBean prototypeBean;

        @Autowired
        private Provider<PrototypeBean> provider;

        // @Autowired
        // public ClientBean(PrototypeBean prototypeBean) {
        //     this.prototypeBean = prototypeBean;
        // }

        public int logic(){
            PrototypeBean prototypeBean = provider.get();
            prototypeBean.addCount();
            int count = prototypeBean.getCount();
            return count;
        }
        
    }

    @Scope("prototype")
    static class PrototypeBean{
        private int count = 0;

        public void addCount(){
            count++;
        }

        public int getCount(){
            return count;
        }

        @PostConstruct
        public void init(){
            System.out.println("inint" + this);
        }

        @PreDestroy
        public void destroy(){
            System.out.println("Destory" + this);
        }
    }
}
