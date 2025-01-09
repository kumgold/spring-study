package com.hellospring.demo;

import com.hellospring.demo.discount.DiscountPolicy;
import com.hellospring.demo.discount.FixDiscountPolicy;
import com.hellospring.demo.discount.RateDiscountPolicy;
import com.hellospring.demo.member.MemberRepository;
import com.hellospring.demo.member.MemberService;
import com.hellospring.demo.member.MemberServiceImpl;
import com.hellospring.demo.member.MemoryMemberRepository;
import com.hellospring.demo.order.OrderService;
import com.hellospring.demo.order.OrderServiceImpl;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class AppConfig {

    @Bean
    public MemberService memberService() {
        return new MemberServiceImpl(memberRepository());
    }

    @Bean
    public OrderService orderService() {
        return new OrderServiceImpl(memberRepository(), discountPolicy());
    }

    @Bean
    public MemberRepository memberRepository() {
        return new MemoryMemberRepository();
    }

    @Bean
    public DiscountPolicy discountPolicy() {
        return new RateDiscountPolicy();
    }
}
