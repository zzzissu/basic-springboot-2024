package com.zzzissu.backboard.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.zzzissu.backboard.entity.Reply;

public interface ReplyRepository extends JpaRepository<Reply, Long>{
    
}
