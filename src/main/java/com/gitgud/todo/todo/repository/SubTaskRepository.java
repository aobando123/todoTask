package com.gitgud.todo.todo.repository;

import com.gitgud.todo.todo.domain.SubTask;
import org.springframework.data.jpa.repository.JpaRepository;

public interface SubTaskRepository extends JpaRepository<SubTask, Long> {
}
