package com.zzzissu.backboard.dto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import java.time.LocalDateTime;
import java.util.List;

@Getter
@Setter
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class BoardDto {
    
    private Long bno; // PK

    private String title; // 글제목

    private String content; // 글내용

    private LocalDateTime createDate; // 글생성일

    private LocalDateTime modifyDate;

    private Integer hit;

    private String writer;

    private List<ReplyDto> replyList;

}
