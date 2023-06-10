package kr.ac.knu.CapstoneDesignProject2.dto.response;

import kr.ac.knu.CapstoneDesignProject2.entity.ChatRoom;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.time.LocalDateTime;
import java.util.List;

@Getter
@Setter
@NoArgsConstructor
public class MyChatRoomDTO {

    private int userEntityId;
    private ChatRoomDTO chatRoomDTO;
    private int lastChatId;

    public MyChatRoomDTO(int userEntityId, ChatRoomDTO chatRoomDTO, int lastChatId) {
        this.userEntityId = userEntityId;
        this.chatRoomDTO = chatRoomDTO;
        this.lastChatId = lastChatId;
    }

}
