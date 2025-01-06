package com.example.hellospring.demo.repository;

import com.example.hellospring.demo.domain.Member;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.Test;

import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;

public class MemoryMemberRepositoryTest {
    private final MemoryMemberRepository repository = new MemoryMemberRepository();

    @AfterEach
    public void afterEach() {
        repository.clear();
    }

    @Test
    void save() {
        Member member = new Member();
        member.setName("spring");

        repository.save(member);

        var result = repository.findById(member.getId()).get();

        assertThat(member).isEqualTo(result);
    }

    @Test
    void findByName() {
        Member member1 = new Member();
        member1.setName("spring1");
        repository.save(member1);

        Member member2 = new Member();
        member2.setName("spring2");
        repository.save(member2);

        Member result = repository.findByName(member1.getName()).get();
        Assertions.assertThat(member1).isEqualTo(result);
    }

    @Test
    void findAll() {
        Member member1 = new Member();
        member1.setName("spring1");
        repository.save(member1);

        Member member2 = new Member();
        member2.setName("spring2");
        repository.save(member2);

        List<Member> result = repository.findAll();
        Assertions.assertThat(result.size()).isEqualTo(2);
    }
}
