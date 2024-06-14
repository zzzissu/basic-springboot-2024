package com.zzzissu.spring02.controller;

import java.util.List;
import com.zzzissu.spring02.domain.Todo;
import com.zzzissu.spring02.service.TodoService;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;

// JavaEE 9이전엔
// import javax.annotation.Resource;
// JavaEE 9 이후
import jakarta.annotation.Resource;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
public class TodoController {
    
    @Resource
    TodoService todoService;

    // localhost:8091/todos 요청하면 실행되는
    @GetMapping("/todos")
    public String getTodos(Model model) throws Exception {
        List<Todo> allTodos = todoService.getTodos();
        model.addAttribute("todoList", allTodos);
        return "todolist";
    }
    
    // http://localhost:8091/todo.do?tno=1 -> 옛날방식
    // http://localhost:8091/todo/1 -> 최신방식
    @GetMapping("/todo/{tno}")
    public @ResponseBody Todo getTodo(@PathVariable int tno) throws Exception {
        return todoService.getTodo(tno);
    }
    //  @ResponseBody 없어도 됨
}
