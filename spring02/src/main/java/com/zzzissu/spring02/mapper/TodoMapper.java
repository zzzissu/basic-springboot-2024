package com.zzzissu.spring02.mapper;

import java.util.List;

import org.apache.ibatis.annotations.Mapper;
// ibatis = mybatis

import com.zzzissu.spring02.domain.Todo;

@Mapper
public interface TodoMapper {
    
    List<Todo> selectTodos() throws Exception;

    Todo selectTodo(int tno) throws Exception;
}
