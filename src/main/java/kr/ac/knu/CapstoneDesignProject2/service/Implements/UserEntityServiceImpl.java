package kr.ac.knu.CapstoneDesignProject2.service.Implements;

import kr.ac.knu.CapstoneDesignProject2.dao.UserEntityRepository;
import kr.ac.knu.CapstoneDesignProject2.entity.UserEntity;
import kr.ac.knu.CapstoneDesignProject2.service.Interfaces.UserEntityService;
import lombok.RequiredArgsConstructor;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
@RequiredArgsConstructor
public class UserEntityServiceImpl implements UserEntityService {

    private final UserEntityRepository userEntityRepository;
    private final PasswordEncoder passwordEncoder;

    @Override
    public List<UserEntity> findAll() {
        return userEntityRepository.findAll();
    }

    @Override
    public UserEntity findById(int theId) {

        Optional<UserEntity> result = userEntityRepository.findById(theId);

        UserEntity theUserEntity = null;

        if (result.isPresent()) {
            theUserEntity = result.get();
        }
        else {
            // we didn't find the user
            throw new RuntimeException("Did not find userEntity id - " + theId);
        }

        return theUserEntity;

    }

    @Override
    public UserEntity save(UserEntity theUserEntity) {
        theUserEntity.setPassword(passwordEncoder.encode(theUserEntity.getPassword()));
        return userEntityRepository.save(theUserEntity);
    }

    @Override
    public void deleteById(int theId) {
        userEntityRepository.deleteById(theId);
    }


}
