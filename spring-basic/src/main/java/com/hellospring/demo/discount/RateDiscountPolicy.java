package com.hellospring.demo.discount;

import com.hellospring.demo.annotation.MainDiscountPolicy;
import com.hellospring.demo.member.Grade;
import com.hellospring.demo.member.Member;
import org.springframework.stereotype.Component;

@Component
@MainDiscountPolicy
public class RateDiscountPolicy implements DiscountPolicy {

    private final int discountPercent = 10;

    @Override
    public int discount(Member member, int price) {
        if (member.getGrade() == Grade.VIP) {
            return price * discountPercent / 100;
        } else {
            return 0;
        }
    }
}
