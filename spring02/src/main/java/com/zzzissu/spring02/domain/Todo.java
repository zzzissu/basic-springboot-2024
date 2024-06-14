package com.zzzissu.spring02.domain;

import java.time.LocalDateTime;

// import lombok.Data;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@Getter
@Setter
@ToString
// @Data -> Getter, Setter, ToString을 세개 다 사용할 때에는 Data로 대체 가능(lombok지원)
public class Todo {
    private int tno;
    private String title;
    private LocalDateTime dueDate;
    private String writer;
    private int isDone;
}
