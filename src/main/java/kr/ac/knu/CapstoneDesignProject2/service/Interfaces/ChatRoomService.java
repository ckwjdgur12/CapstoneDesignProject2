package kr.ac.knu.CapstoneDesignProject2.service.Interfaces;

import kr.ac.knu.CapstoneDesignProject2.dto.ChatRoomDTO;
import kr.ac.knu.CapstoneDesignProject2.entity.ChatRoom;

import java.util.List;

public interface ChatRoomService {

    ChatRoomDTO findById(int theId);

    ChatRoom save(ChatRoom theChatRoom);

    void deleteById(int theId);

    List<ChatRoomDTO> getAllChatRoomsOrderByUpdatedAt();

    List<ChatRoomDTO> getChatRoomsByCategoryId(int categoryId);

}
