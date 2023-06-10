package kr.ac.knu.CapstoneDesignProject2.service.Interfaces;

import kr.ac.knu.CapstoneDesignProject2.dto.response.ChatRoomTagDTO;
import kr.ac.knu.CapstoneDesignProject2.entity.ChatRoom;
import kr.ac.knu.CapstoneDesignProject2.entity.ChatRoomTag;

import java.util.List;

public interface ChatRoomTagService {

    List<ChatRoomTagDTO> findAll();

    ChatRoomTagDTO findById(int theId);

    List<ChatRoomTag> findByChatRoom(ChatRoom theChatRoom);

    ChatRoomTag save(ChatRoomTag theChatRoomTag);

    void deleteById(int theId);

    void deleteByChatRoom(ChatRoom theChatRoom);

}
