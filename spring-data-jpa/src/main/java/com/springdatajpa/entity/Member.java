package com.springdatajpa.entity;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;
import lombok.Getter;

@Entity
@Getter
//@Setter // 실무에선 가급적 사용 X. 강의 편의상 사용 중
public class Member {

    @Id @GeneratedValue
    private Long id;
    private String name;

    // cf. JPA를 사용할 때 Entity에 '기본 생성자'가 필요하며 private으로 해선 안된다.
    // 왜냐면 JPA 구현체들(e.g. Hibernate)이 proxy 기술을 사용하여 ~~ 객체를 생성할 때 이 기본 생성자를 사용하기 때문이다.
    protected Member(){}

    public Member(String name){
        this.name = name;
    }
}
