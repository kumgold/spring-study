package com.example.hellospring.demo.service;

import com.example.hellospring.demo.domain.Member;
import com.example.hellospring.demo.repository.MemberRepository;
import jakarta.transaction.Transactional;

import java.util.List;
import java.util.Optional;

@Transactional
public class MemberService {
    private final MemberRepository repository;

    public MemberService(MemberRepository repository) {
        this.repository = repository;
    }

    public Long join(Member member) {
        checkDuplicatedMember(member);
        repository.save(member);
        return member.getId();
    }

    private void checkDuplicatedMember(Member member) {
        repository.findByName(member.getName()).ifPresent(m -> {
            throw new IllegalStateException("이미 존재하는 회원입니다");
        });
    }

    public List<Member> findAllMembers() {
        return repository.findAll();
    }

    public Optional<Member> findMemberFromId(Long id) {
        return repository.findById(id);
    }
}
