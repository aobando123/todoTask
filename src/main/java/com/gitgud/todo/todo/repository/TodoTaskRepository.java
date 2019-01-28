package com.gitgud.todo.todo.repository;

import com.gitgud.todo.todo.domain.TodoTask;
import org.springframework.data.jpa.repository.JpaRepository;

public interface TodoTaskRepository extends JpaRepository<TodoTask, Long> {
}
