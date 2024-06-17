package com.zzzissu.backboard.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.zzzissu.backboard.entity.Board;

public interface BoardRepository extends JpaRepository<Board, Long> {
    
}
