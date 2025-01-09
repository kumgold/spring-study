package com.hellospring.demo.discount;

import com.hellospring.demo.member.Member;

public interface DiscountPolicy {
    int discount(Member member, int price);
}
