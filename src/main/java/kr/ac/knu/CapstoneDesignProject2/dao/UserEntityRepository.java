package kr.ac.knu.CapstoneDesignProject2.dao;

import kr.ac.knu.CapstoneDesignProject2.entity.Category;
import kr.ac.knu.CapstoneDesignProject2.entity.UserEntity;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;
import java.util.Optional;

public interface UserEntityRepository extends JpaRepository<UserEntity, Integer> {

    Optional<UserEntity> findByUserId(String userId);

}
