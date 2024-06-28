package com.zzzissu.backboard.repository;

import java.util.Optional;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.zzzissu.backboard.entity.Member;

@Repository
public interface MemberRepository extends JpaRepository<Member, Long>{

    Optional<Member> findByUsername(String username);
    Optional<Member> findByEmail(String email);
    
}
