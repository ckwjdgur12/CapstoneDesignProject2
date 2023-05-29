package kr.ac.knu.CapstoneDesignProject2.service.Interfaces;

import kr.ac.knu.CapstoneDesignProject2.entity.MyChatRoom;

import java.util.List;

public interface MyChatRoomService {

    List<MyChatRoom> findAll();

    MyChatRoom findById(int theId);

    MyChatRoom save(MyChatRoom theMyChatRoom);

    void deleteById(int theId);

}
