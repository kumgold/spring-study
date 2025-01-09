package com.hellospring.demo.member;

import lombok.Getter;
import org.springframework.stereotype.Component;

@Getter
@Component
public class MemberServiceImpl implements MemberService {

    private final MemberRepository memoryMemberRepository;

    public MemberServiceImpl(MemberRepository memoryMemberRepository) {
        this.memoryMemberRepository = memoryMemberRepository;
    }

    @Override
    public void join(Member member) {
        memoryMemberRepository.save(member);
    }

    @Override
    public Member findMember(Long memberId) {
        return memoryMemberRepository.findById(memberId);
    }
}
