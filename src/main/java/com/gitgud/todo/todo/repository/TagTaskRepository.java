package com.gitgud.todo.todo.repository;

import com.gitgud.todo.todo.domain.Tag;
import org.springframework.data.jpa.repository.JpaRepository;

public interface TagTaskRepository extends JpaRepository<Tag, Long> {
}
