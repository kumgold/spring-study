package com.example.hellospring.demo.service;

import com.example.hellospring.demo.domain.Member;
import com.example.hellospring.demo.repository.MemoryMemberRepository;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class MemberServiceTest {
    private final MemoryMemberRepository repository = new MemoryMemberRepository();
    private final MemberService memberService = new MemberService(repository);

    @AfterEach
    void afterEach() {
        repository.clear();
    }

    @Test
    void join() {
        Member member = new Member();
        member.setName("hello");

        Long savedId = memberService.join(member);
        Member findMember = memberService.findMemberFromId(savedId).get();

        Assertions.assertThat(member.getId()).isEqualTo(findMember.getId());
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

    @Test
    void findAllMembers() {
    }

    @Test
    void findMemberFromId() {
    }
}