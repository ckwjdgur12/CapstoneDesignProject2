package kr.ac.knu.CapstoneDesignProject2.dao;

import kr.ac.knu.CapstoneDesignProject2.entity.ChatRoom;
import kr.ac.knu.CapstoneDesignProject2.entity.ChatRoomTag;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;
import java.util.Optional;

public interface ChatRoomTagRepository extends JpaRepository<ChatRoomTag, Integer> {

    void deleteByChatRoom(ChatRoom theChatRoom);

    List<ChatRoomTag> findByChatRoom(ChatRoom theChatRoom);
}
