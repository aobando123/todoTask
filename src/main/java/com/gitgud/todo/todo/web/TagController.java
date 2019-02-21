package com.gitgud.todo.todo.web;

import com.gitgud.todo.todo.domain.Tag;
import com.gitgud.todo.todo.service.TagService;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/tag")
public class TagController {

    private final TagService _tagService;

    public  TagController(TagService subTaskService) {
        this._tagService = subTaskService;
    }

    @GetMapping()
    public List<Tag> getAll() {
        return _tagService.getAll();
    }
    @PostMapping()
    public  Tag save(@RequestBody Tag subTask) {
        return  _tagService.save(subTask);
    }
    @PutMapping()
    public Tag update(@RequestBody Tag subTask){
        return  _tagService.update(subTask);
    }

}
