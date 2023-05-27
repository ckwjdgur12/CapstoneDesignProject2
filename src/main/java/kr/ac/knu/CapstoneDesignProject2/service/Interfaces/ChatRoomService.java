package kr.ac.knu.CapstoneDesignProject2.service.Interfaces;

import kr.ac.knu.CapstoneDesignProject2.entity.ChatRoom;

import java.util.List;

public interface ChatRoomService {

    ChatRoom findById(int theId);

    ChatRoom save(ChatRoom theChatRoom);

    void deleteById(int theId);

    List<ChatRoom> getAllChatRoomsOrderByUpdatedAt();

    List<ChatRoom> getChatRoomsByCategoryId(int categoryId);

}
