package com.gitgud.todo.todo.web;

import com.gitgud.todo.todo.domain.TodoTask;
import com.gitgud.todo.todo.service.TodoService;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/todo")
public class TodoController {
    private final TodoService todoService;
    public TodoController (TodoService todoService) {
        this.todoService = todoService;
    }

    @GetMapping()
    public List<TodoTask> getAll() {
        return todoService.findAll();
    }

    @GetMapping("/find-by-id/{taskId}")
    public TodoTask getByIdPath(@PathVariable Long taskId) {
        return todoService.findById(taskId);
    }
    @GetMapping("/find-by-id")
    public TodoTask getByIdQuery(@RequestParam("taskId") Long taskId) {
        return todoService.findById(taskId);
    }

    @PostMapping()
    public TodoTask postTodo(@RequestBody TodoTask todoTask) {
        return todoService.save(todoTask);
    }

    @PutMapping()
    public TodoTask putTodo(@RequestBody TodoTask todoTask) {
        return todoService.update(todoTask);
    }


}
