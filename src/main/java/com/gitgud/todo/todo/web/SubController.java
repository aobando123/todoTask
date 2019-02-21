package com.gitgud.todo.todo.web;

import com.gitgud.todo.todo.domain.SubTask;
import com.gitgud.todo.todo.service.SubTaskService;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/subtask")
public class SubController {
    private final SubTaskService subTaskService;
    public  SubController(SubTaskService subTaskService) {
        this.subTaskService = subTaskService;
    }
    @GetMapping()
    public List<SubTask> getAll() {
        return subTaskService.getAll();
    }
    @PostMapping()
    public  SubTask save(@RequestBody SubTask subTask) {
        return  subTaskService.save(subTask);
    }
    @PutMapping()
    public SubTask update(@RequestBody SubTask subTask){
        return  subTaskService.update(subTask);
    }
}
