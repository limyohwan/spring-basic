package com.hello.core.discount;

import static org.assertj.core.api.Assertions.*;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import com.hello.core.member.Grade;
import com.hello.core.member.Member;

public class RateDiscountPolicyTest {

    RateDiscountPolicy discountPolicy = new RateDiscountPolicy();

    @Test
    @DisplayName("VIP는 10프로 할인이 적용되어야한다")
    void vip_o(){
        Member member = new Member(1L, "memverVIP", Grade.VIP);

        int discount = discountPolicy.discount(member, 20000);

        assertThat(discount).isEqualTo(2000);
    }

    @Test
    @DisplayName("VIP가아니면 적용 안된다")
    void vip_x(){
        Member member = new Member(1L, "memverVIP", Grade.BASIC);

        int discount = discountPolicy.discount(member, 20000);

        assertThat(discount).isEqualTo(0);
    }
}
