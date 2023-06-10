package kr.ac.knu.CapstoneDesignProject2.service.Interfaces;

import kr.ac.knu.CapstoneDesignProject2.dto.response.ChatRoomDTO;
import kr.ac.knu.CapstoneDesignProject2.dto.response.MyChatRoomDTO;
import kr.ac.knu.CapstoneDesignProject2.entity.MyChatRoom;
import kr.ac.knu.CapstoneDesignProject2.entity.UserEntity;

import java.util.List;

public interface MyChatRoomService {

    List<MyChatRoomDTO> findAll();

    MyChatRoomDTO findById(int theId);

    MyChatRoom save(MyChatRoom theMyChatRoom);

    void deleteById(int theId);

    List<MyChatRoomDTO> findByUserEntity(int userEntityId);
}
