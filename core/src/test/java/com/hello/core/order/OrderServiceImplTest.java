package com.hello.core.order;

import org.junit.jupiter.api.Test;

import com.hello.core.discount.FixDiscountPolicy;
import com.hello.core.member.Grade;
import com.hello.core.member.Member;
import com.hello.core.member.MemoryMemberRepository;

public class OrderServiceImplTest {


    @Test
    public void creatOrder(){

        MemoryMemberRepository memberRepository = new MemoryMemberRepository();
        memberRepository.save(new Member(1L,"name", Grade.VIP));

        OrderServiceImpl orderService = new OrderServiceImpl(memberRepository, new FixDiscountPolicy());


        Order order = orderService.createOrder(1L, "member", 10000);
        System.out.println(order.getDiscountPrice());
    
    }
}
