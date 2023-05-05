package kr.ac.knu.CapstoneDesignProject2.dao;

import kr.ac.knu.CapstoneDesignProject2.entity.ChatRoom;
import kr.ac.knu.CapstoneDesignProject2.entity.ChatRoomTag;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ChatRoomTagRepository extends JpaRepository<ChatRoomTag, Integer> {

}
