package com.example.hellospring.demo.service;

import com.example.hellospring.demo.domain.Member;
import com.example.hellospring.demo.repository.MemberRepository;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.transaction.annotation.Transactional;

import static org.junit.jupiter.api.Assertions.assertThrows;

@SpringBootTest
@Transactional
public class MemberServiceIntegrationTest {
    @Autowired MemberRepository repository;
    @Autowired MemberService memberService;

    @Test
    void join() {
        Member member = new Member();
        member.setName("hello");

        Long savedId = memberService.join(member);

        Member findMember = memberService.findMemberFromId(savedId).get();
        Assertions.assertThat(member.getName()).isEqualTo(findMember.getName());
    }

    @Test
    void duplicatedMemberTest() {
        Member member1 = new Member();
        member1.setName("hi");

        Member member2 = new Member();
        member2.setName("hi");

        memberService.join(member1);

        assertThrows(IllegalStateException.class, () -> memberService.join(member2));
    }
}
