package com.springdatajpa.repository;

import com.springdatajpa.entity.Member;
import org.springframework.data.jpa.repository.JpaRepository;

public interface MemberRepository extends JpaRepository<Member, Long> {

}
