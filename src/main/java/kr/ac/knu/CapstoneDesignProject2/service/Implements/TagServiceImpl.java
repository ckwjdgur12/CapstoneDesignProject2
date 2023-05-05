package kr.ac.knu.CapstoneDesignProject2.service.Implements;

import kr.ac.knu.CapstoneDesignProject2.dao.TagRepository;
import kr.ac.knu.CapstoneDesignProject2.entity.Tag;
import kr.ac.knu.CapstoneDesignProject2.service.Interfaces.TagService;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class TagServiceImpl implements TagService {

    private TagRepository tagRepository;

    public TagServiceImpl(TagRepository tagRepository) {
        this.tagRepository = tagRepository;
    }

    @Override
    public List<Tag> findAll() {
        return tagRepository.findAll();
    }

    @Override
    public Tag findById(int theId) {

        Optional<Tag> result = tagRepository.findById(theId);

        Tag theTag = null;

        if (result.isPresent()) {
            theTag = result.get();
        }
        else {
            // we didn't find the user
            throw new RuntimeException("Did not find tag id - " + theId);
        }

        return theTag;

    }

    @Override
    public Tag save(Tag theTag) {
        return tagRepository.save(theTag);
    }

    @Override
    public void deleteById(int theId) {
        tagRepository.deleteById(theId);
    }


}
