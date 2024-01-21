package com.springdatajpa.repository;

import com.springdatajpa.entity.Member;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.annotation.Rollback;
import org.springframework.transaction.annotation.Transactional;

import static org.assertj.core.api.Assertions.assertThat;

//@RunWith(SpringRunner.class) // 과거 JUnit 4 를 사용하던 시절에는 이러한 어노테이션이 필요했지만
@SpringBootTest // 스프링부트 + JUnit 5 조합에선 @SpringBootTest 어노테이션으로 해결했다?
@Transactional // <- 없을시 해당 에러 발생 : No EntityManager with actual transaction available for current thread - cannot reliably process 'persist' call
@Rollback(false)
class MemberJpaRepositoryTest {

    @Autowired
    MemberJpaRepository repository;

    @Test // org.junit.jupiter.api.Test , jupiter가 JUnit 5이기 때문에 jupiter 패키지를 사용해야 한다.
    public void testMember(){
        // given
        Member member = new Member("김영한");

        // when
        Member saveMember = repository.save(member);
        Member findMember = repository.find(saveMember.getId());

        // then
        assertThat(findMember.getId()).isEqualTo(saveMember.getId());
        assertThat(findMember).isEqualTo(saveMember); // findMember == saveMember 와 같은 의미이다.
        // 왜냐하면 JPA 특성상 동일 트랜잭션 내에서는 영속성 컨텍스트의 '동일성'을 보장한다. 그래서 내가 저장한 놈과 찾은 놈이 동일하게 되는 것이다.
        // 당연히 트랜잭션이 다르면 다른 객체이다? (JPA 기본 공부를 해야 이해할 듯)
    }
}