package kr.ac.knu.CapstoneDesignProject2.dao;

import kr.ac.knu.CapstoneDesignProject2.entity.MyChatRoom;
import kr.ac.knu.CapstoneDesignProject2.entity.UserEntity;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface MyChatRoomRepository extends JpaRepository<MyChatRoom, Integer> {

    List<MyChatRoom> findByTheUserEntity(UserEntity userEntity);

}
