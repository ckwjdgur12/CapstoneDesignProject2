package kr.ac.knu.CapstoneDesignProject2.service.Interfaces;

import kr.ac.knu.CapstoneDesignProject2.dto.ChatRoomTagDTO;
import kr.ac.knu.CapstoneDesignProject2.entity.ChatRoomTag;

import java.util.List;

public interface ChatRoomTagService {

    List<ChatRoomTagDTO> findAll();

    ChatRoomTagDTO findById(int theId);

    ChatRoomTag save(ChatRoomTag theChatRoomTag);

    void deleteById(int theId);

}
