package kr.ac.knu.CapstoneDesignProject2.service.Interfaces;

import kr.ac.knu.CapstoneDesignProject2.entity.Tag;

import java.util.List;

public interface TagService {

    List<Tag> findAll();

    Tag findById(int theId);

    Tag save(Tag theTag);

    void deleteById(int theId);

}
