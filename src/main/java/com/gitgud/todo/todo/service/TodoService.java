package com.gitgud.todo.todo.service;

import com.gitgud.todo.todo.domain.TodoTask;
import com.gitgud.todo.todo.repository.TodoTaskRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;


import java.util.List;
import java.util.Optional;


@Service
@Transactional
public class TodoService {
    private final TodoTaskRepository todoTaskRepository;
    public  TodoService (TodoTaskRepository todoTaskRepository) {
        this.todoTaskRepository = todoTaskRepository;
    }

    @Transactional(readOnly = true)
    public List<TodoTask> findAll() {
        return  todoTaskRepository.findAll();
    }
    @Transactional(readOnly = true)
    public TodoTask findById(Long idTask) {
        Optional<TodoTask> todoTask =  todoTaskRepository.findById(idTask);
        return todoTask.isPresent() ? todoTask.get() : null;
    }
    @Transactional
    public TodoTask save(TodoTask todoTask) {
        return todoTaskRepository.save(todoTask);
    }
    @Transactional
    public TodoTask update(TodoTask todoTask) {
        boolean isPresent = todoTaskRepository.findById(todoTask.getId()).isPresent();
        return isPresent ? todoTaskRepository.save(todoTask) : null;
    }
}
