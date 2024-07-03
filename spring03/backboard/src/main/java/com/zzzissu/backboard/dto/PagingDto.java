package com.zzzissu.backboard.dto;

import groovy.transform.builder.Builder;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class PagingDto {
    
    private int pageSize;       // 화면당 보여지는 게시글 최대개수
    private int totalPageNum;   // 총 페이지 수
    private long totallistSize; // 총 게시글 수

    private int page;           // 현재 페이지
    private int startPage;      // 시작 페이지 번호
    private int endPage;        // 마지막 페이지 번호

    private int startIndex;     // 시작 인덱스 번호

    private int block;          // 현재 블럭(구간)
    private int totalBlockNum;  // 총 블럭 수
    private int prevBlock;      // 이전 블럭
    private int nextBlock;      // 다음 블럭

    public PagingDto() {
        
    }
}
