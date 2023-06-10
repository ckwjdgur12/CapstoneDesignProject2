package kr.ac.knu.CapstoneDesignProject2.dao;

import kr.ac.knu.CapstoneDesignProject2.entity.Category;
import kr.ac.knu.CapstoneDesignProject2.entity.ChatRoom;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;
import java.util.Optional;

public interface ChatRoomRepository extends JpaRepository<ChatRoom, Integer> {

    @Query("SELECT cr FROM ChatRoom cr ORDER BY cr.updateAt DESC")
    List<ChatRoom> getAllChatRoomsOrderByUpdatedAt();

    List<ChatRoom> findAllByTheCategoryOrderByUpdateAtDesc(Category category);

    Optional<ChatRoom> findByChatRoomTitle(String chatRoomTitle);
}
