package com.zzzissu.backboard.entity;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import lombok.Builder;
import lombok.Data;

@Data
@Entity
@Builder
public class Member {
    
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE)
    private Long mid;

    @Column(unique = true, length = 100)
    private String username;

    @Column(unique = true, length = 150)
    private String email;

    private String password;
}
