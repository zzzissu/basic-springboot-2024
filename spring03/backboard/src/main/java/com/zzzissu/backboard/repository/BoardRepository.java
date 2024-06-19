package com.zzzissu.backboard.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.zzzissu.backboard.entity.Board;

@Repository
public interface BoardRepository extends JpaRepository<Board, Long> {
    
}
