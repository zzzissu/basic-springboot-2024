package com.zzzissu.backboard.repository;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;

import com.zzzissu.backboard.entity.Reset;

public interface ResetRepository extends JpaRepository<Reset,Integer>{
    
    Optional<Reset> findByUuid(String uuid);    // UUID로 테이블 검색
}
