package com.springdatajpa.repository;

import com.springdatajpa.entity.Member;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.annotation.Rollback;
import org.springframework.transaction.annotation.Transactional;

import java.util.Optional;

import static org.assertj.core.api.Assertions.assertThat;

@SpringBootTest
@Transactional
@Rollback(value = false)
class MemberRepositoryTest {

    @Autowired
    MemberRepository memberRepository;

    @Test
    public void testMember(){
        Member member = new Member("김영한");
        Member saveMember = memberRepository.save(member);
        Optional<Member> optionalMember = memberRepository.findById(saveMember.getId());

        //
        optionalMember.ifPresent(m -> assertThat(m.getId()).isEqualTo(saveMember.getId()));
    }
}