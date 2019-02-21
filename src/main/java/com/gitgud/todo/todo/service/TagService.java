package com.gitgud.todo.todo.service;

import com.gitgud.todo.todo.domain.Tag;
import com.gitgud.todo.todo.repository.TagTaskRepository;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Optional;

@Service
@Transactional
public class TagService {

    private final TagTaskRepository _tagTaskRepository;

    public TagService (TagTaskRepository tagTaskRepository){
        _tagTaskRepository = tagTaskRepository;
    }

    @Transactional(readOnly = true)
    public List<Tag> getAll() {
        return  _tagTaskRepository.findAll();
    }

    public Tag save(Tag subTask) {
        return _tagTaskRepository.save(subTask);
    }

    public  Tag update(Tag tag) {
        Optional<Tag> optSubTask = _tagTaskRepository.findById(tag.getId());
        if(optSubTask.isPresent()) {
            return  _tagTaskRepository.save(tag);
        }
        return null;
    }

}
