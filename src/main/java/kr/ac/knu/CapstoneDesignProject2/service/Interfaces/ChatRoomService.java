package kr.ac.knu.CapstoneDesignProject2.service.Interfaces;

import kr.ac.knu.CapstoneDesignProject2.dto.request.ChatRoomRequestDTO;
import kr.ac.knu.CapstoneDesignProject2.dto.response.ChatRoomDTO;
import kr.ac.knu.CapstoneDesignProject2.entity.ChatRoom;

import java.util.List;

public interface ChatRoomService {

    ChatRoomDTO findById(int theId);

    ChatRoomDTO findByChatRoomTitle(String chatRoomTitle);

    ChatRoom save(ChatRoom theChatRoom);

    ChatRoom addChatRoom(ChatRoomRequestDTO chatRoomRequestDTO);

    ChatRoom updateChatRoom(int chatRoomId, ChatRoomRequestDTO chatRoomRequestDTO);

    void deleteById(int theId);

    List<ChatRoomDTO> getAllChatRoomsOrderByUpdatedAt();

    List<ChatRoomDTO> getChatRoomsByCategoryId(int categoryId);

}
