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

    @GetMapping("/find-category")
    public List<TodoTask> findCategory(@RequestParam("category") String category) {
        return todoService.findByCategory(category);
    }
    @GetMapping("/search-category")
    public List<TodoTask> findByLikeCategory(@RequestParam("category") String category) {
        return todoService.findLikeCategory(category);
    }
    @GetMapping("/last-results")
    public List<TodoTask> findByLikeCategory() {
        return todoService.findByCategoryLastFive();
    }
    @GetMapping("/find-results-status")
    public List<TodoTask> findByStatus(@RequestParam("status") String status) {
        return todoService.findFirstFiveStatus(status);
    }
    @PutMapping("/update-status/{taskId}")
    public TodoTask updateStatus(@PathVariable Long taskId,@RequestParam("status") String status) {
        return  todoService.updateStatusTask(taskId, status);
    }
    @GetMapping("/creation-date")
    public  List<TodoTask> findByCreationDate(@RequestParam("createdDate") String createdDate) {
        return todoService.findByCreatedDate(createdDate);
    }

}
