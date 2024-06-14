package com.zzzissu.spring02.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.zzzissu.spring02.domain.Todo;
import com.zzzissu.spring02.mapper.TodoMapper;

@Service
public class TodoServicelmpl implements TodoService {

    @Autowired
    TodoMapper todoMapper;

    @Override
    public List<Todo> getTodos() throws Exception {
        return todoMapper.selectTodos();
        // xml에 있는 쿼리를 반환
    }

    @Override
    public Todo getTodo(int tno) throws Exception {
        return todoMapper.selectTodo(tno);
    }
    
}
