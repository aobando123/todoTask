package com.gitgud.todo.todo.repository;

import com.gitgud.todo.todo.domain.TodoTask;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;

public interface TodoTaskRepository extends JpaRepository<TodoTask, Long> {
    @Query("SELECT todoTask from TodoTask todoTask where todoTask.category = :category ")
    List<TodoTask> findByNameCategory(@Param("category") String category);

    @Query("SELECT todoTask FROM TodoTask todoTask WHERE todoTask.category LIKE :category ")
    List<TodoTask> findByCatagorySimilar(@Param("category") String category);

    @Query("select todoTask from TodoTask todoTask order by todoTask.id desc")
    Page<TodoTask> lastResults(Pageable pageable);

    List<TodoTask> findTop5ByStatus(String status);
    @Query("SELECT todo from TodoTask todo where createdDate = :createdDate ")
    List<TodoTask> findByCreateDate(@Param("createdDate") String createdDate);

}