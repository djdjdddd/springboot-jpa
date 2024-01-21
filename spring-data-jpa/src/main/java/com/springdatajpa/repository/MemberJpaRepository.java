package com.springdatajpa.repository;

import com.springdatajpa.entity.Member;
import jakarta.persistence.EntityManager;
import jakarta.persistence.PersistenceContext;
import org.springframework.stereotype.Repository;

@Repository
public class MemberJpaRepository {

    @PersistenceContext // <- 이 PersistenceContext(영속성 컨텍스트) 어노테이션을 사용하면 스프링 컨테이너가 EntityManager라는 놈을 주입해준다.
                        // 그리고 JPA는 이 em을 이용하여 CRUD 쿼리를 수행하게 되는 것이다.
    private EntityManager em;

    public Member save(Member member){
        em.persist(member);
        return member;
    }

    public Member find(Long id){
        return em.find(Member.class, id);
    }
}
