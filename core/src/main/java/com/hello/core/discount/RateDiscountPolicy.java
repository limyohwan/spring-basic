package com.hello.core.discount;

import org.springframework.context.annotation.Primary;
import org.springframework.stereotype.Component;

import com.hello.core.annotation.MainDiscountPolicy;
import com.hello.core.member.Grade;
import com.hello.core.member.Member;

@Component
@MainDiscountPolicy
public class RateDiscountPolicy implements DiscountPolicy {

    private int discountFixPercent = 10;

    @Override
    public int discount(Member member, int price) {
        if(member.getGrade() == Grade.VIP){
            return price / 100 * discountFixPercent;
        }else{
            return 0;
        }
    }
}
