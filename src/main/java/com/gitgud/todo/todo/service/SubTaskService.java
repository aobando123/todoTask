package com.gitgud.todo.todo.service;

import com.gitgud.todo.todo.domain.SubTask;
import com.gitgud.todo.todo.repository.SubTaskRepository;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Optional;

@Service
@Transactional
public class SubTaskService {
    private final SubTaskRepository subTaskRepository;

    public SubTaskService(SubTaskRepository subTaskRepository) {
        this.subTaskRepository = subTaskRepository;
    }
    @Transactional(readOnly = true)
    public List<SubTask> getAll() {
        return  subTaskRepository.findAll();
    }

    public SubTask save(SubTask subTask) {
        return subTaskRepository.save(subTask);
    }

    public  SubTask update(SubTask subTask) {
        Optional<SubTask> optSubTask = subTaskRepository.findById(subTask.getId());
        if(optSubTask.isPresent()) {
            return  subTaskRepository.save(subTask);
        }
        return null;
    }



}
