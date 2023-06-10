package kr.ac.knu.CapstoneDesignProject2.dao;

import kr.ac.knu.CapstoneDesignProject2.entity.Category;
import kr.ac.knu.CapstoneDesignProject2.entity.Tag;
import kr.ac.knu.CapstoneDesignProject2.entity.UserEntity;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface TagRepository extends JpaRepository<Tag, Integer> {

    Optional<Tag> findByTag(String tag);

}
