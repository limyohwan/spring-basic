package com.hello.core;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.FilterType;

import com.hello.core.member.MemberRepository;
import com.hello.core.member.MemoryMemberRepository;

@Configuration
@ComponentScan(
    // basePackages = "com.hello.core", //default는 componentscan이 붙은 클래스의 패키지
    // basePackageClasses = AutoAppConfig.class,
    excludeFilters = @ComponentScan.Filter(type = FilterType.ANNOTATION, classes = Configuration.class)
)
public class AutoAppConfig {

    // @Bean(name="memoryMemberRepository")
    // MemberRepository memberRepository(){
    //     return new MemoryMemberRepository();
    // }
    
}
