package com.gitgud.todo.todo.service;

import com.gitgud.todo.todo.domain.TodoTask;
import com.gitgud.todo.todo.repository.TodoTaskRepository;
import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.Comparator;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;


@Service
@Transactional
public class TodoService {
    private final TodoTaskRepository todoTaskRepository;

    public TodoService(TodoTaskRepository todoTaskRepository) {
        this.todoTaskRepository = todoTaskRepository;
    }

    @Transactional(readOnly = true)
    public List<TodoTask> findAll() {
        return todoTaskRepository.findAll();
    }

    @Transactional(readOnly = true)
    public TodoTask findById(Long idTask) {
        Optional<TodoTask> todoTask = todoTaskRepository.findById(idTask);
        return todoTask.isPresent() ? todoTask.get() : null;
    }

    public TodoTask save(TodoTask todoTask) {
        return todoTaskRepository.save(todoTask);
    }

    public TodoTask update(TodoTask todoTask) {
        boolean isPresent = todoTaskRepository.findById(todoTask.getId()).isPresent();
        return isPresent ? todoTaskRepository.save(todoTask) : null;
    }

    @Transactional(readOnly = true)
    public List<TodoTask> findByCategory(String category) {
        return todoTaskRepository.findByNameCategory(category);
    }

    @Transactional(readOnly = true)
    public List<TodoTask> findLikeCategory(String category) {
        return todoTaskRepository.findByCatagorySimilar(category);
    }

    @Transactional(readOnly = true)
    public List<TodoTask> findByCategoryLastFive() {
        return todoTaskRepository.lastResults(PageRequest.of(0, 5))
                .stream()
                .sorted(Comparator.comparing(TodoTask::getCategory))
                .collect(Collectors.toList());
    }

    @Transactional(readOnly = true)
    public List<TodoTask> findFirstFiveStatus(String status) {
        return todoTaskRepository.findTop5ByStatus(status);
    }

    @Transactional(readOnly = true)
    public List<TodoTask> findByCreatedDate(String createdDate) {
        return todoTaskRepository.findByCreateDate(createdDate);
    }

    public TodoTask updateStatusTask(Long idTask, String status) {
        Optional<TodoTask> todoTask = todoTaskRepository.findById(idTask);
        if (todoTask.isPresent()) {
            TodoTask dbTodo = todoTask.get();
            dbTodo.setStatus(status);
            todoTaskRepository.save(dbTodo);
            return todoTaskRepository.save(dbTodo);
        }
        return null;
    }

}
