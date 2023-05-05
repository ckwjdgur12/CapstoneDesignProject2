package kr.ac.knu.CapstoneDesignProject2.service.Interfaces;

import kr.ac.knu.CapstoneDesignProject2.entity.UserEntity;

import java.util.List;

public interface UserEntityService {

    List<UserEntity> findAll();

    UserEntity findById(int theId);

    UserEntity save(UserEntity theUserEntity);

    void deleteById(int theId);

}
