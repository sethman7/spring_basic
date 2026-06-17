package studio.thinkground.springbasic.repository;

import studio.thinkground.springbasic.domain.Member;

import java.util.List;
import java.util.Optional;


public interface MemberRepository {

    //JpaRepository가 제공
    Member save(Member member);
    Optional<Member> findById(long id);
    List<Member> findAll();

    //Spring Data JPA가 메서드 이름을 분석해서 구현체 자동 생성
    Optional<Member> findByName(String name);
}
