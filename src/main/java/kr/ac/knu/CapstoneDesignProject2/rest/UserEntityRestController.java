package kr.ac.knu.CapstoneDesignProject2.rest;

import kr.ac.knu.CapstoneDesignProject2.entity.UserEntity;
import kr.ac.knu.CapstoneDesignProject2.rest.exceptionHandler.MyNotFoundException;
import kr.ac.knu.CapstoneDesignProject2.service.Interfaces.UserEntityService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api")
public class UserEntityRestController {

    private UserEntityService userEntityService;

    @Autowired
    public UserEntityRestController(UserEntityService userEntityService) {
        this.userEntityService = userEntityService;
    }

    @GetMapping("/users")
    public List<UserEntity> findAll() {
        return userEntityService.findAll();
    }

    @GetMapping("/users/{userEntityId}")
    public UserEntity getUserEntity(@PathVariable int userEntityId) {

        UserEntity theUserEntity = userEntityService.findById(userEntityId);

        if (theUserEntity == null) {
            throw new MyNotFoundException("UserEntity id not found - " + userEntityId);
        }

        return theUserEntity;
    }

    @PostMapping("/users")
    public UserEntity addUserEntity(@RequestBody UserEntity theUserEntity){
        theUserEntity.setUserEntityId(0);
        UserEntity dbUserEntity = userEntityService.save(theUserEntity);
        return dbUserEntity;
    }

    @PutMapping("/users")
    public UserEntity updateUserEntity(@RequestBody UserEntity theUserEntity) {

        UserEntity dbUserEntity = userEntityService.save(theUserEntity);

        return dbUserEntity;
    }

    @DeleteMapping("/users/{userEntityId}")
    public String deleteUserEntity(@PathVariable int userEntityId) {

        UserEntity tmpUserEntity = userEntityService.findById(userEntityId);

        if (tmpUserEntity == null) {
            throw new MyNotFoundException("UserEntity id not found - " + userEntityId);
        }

        userEntityService.deleteById(userEntityId);

        return "Deleted userEntity Id - " + userEntityId;
    }

}
