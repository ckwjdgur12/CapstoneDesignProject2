package kr.ac.knu.CapstoneDesignProject2.rest;

import kr.ac.knu.CapstoneDesignProject2.entity.Tag;
import kr.ac.knu.CapstoneDesignProject2.rest.exceptionHandler.MyNotFoundException;
import kr.ac.knu.CapstoneDesignProject2.service.Interfaces.TagService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api")
public class TagRestController {

    private TagService tagService;

    @Autowired
    public TagRestController(TagService tagService) {
        this.tagService = tagService;
    }

    @GetMapping("/tags")
    public List<Tag> findAll() {
        return tagService.findAll();
    }

    @GetMapping("/tags/{tagId}")
    public Tag getTag(@PathVariable int tagId) {

        Tag theTag = tagService.findById(tagId);

        if (theTag == null) {
            throw new MyNotFoundException("Tag id not found - " + tagId);
        }

        return theTag;
    }

    @PostMapping("/tags")
    public Tag addTag(@RequestBody Tag theTag){
        theTag.setTagId(0);
        Tag dbTag = tagService.save(theTag);
        return dbTag;
    }

    @PutMapping("/tags")
    public Tag updateTag(@RequestBody Tag theTag) {

        Tag dbTag = tagService.save(theTag);

        return dbTag;
    }

    @DeleteMapping("/tags/{tagId}")
    public String deleteTag(@PathVariable int tagId) {

        Tag tmpTag = tagService.findById(tagId);

        if (tmpTag == null) {
            throw new MyNotFoundException("Tag id not found - " + tagId);
        }

        tagService.deleteById(tagId);

        return "Deleted tag Id - " + tagId;
    }

}
