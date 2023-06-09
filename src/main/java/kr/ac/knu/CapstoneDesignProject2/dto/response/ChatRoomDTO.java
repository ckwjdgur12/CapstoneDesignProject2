package kr.ac.knu.CapstoneDesignProject2.dto.response;

import kr.ac.knu.CapstoneDesignProject2.entity.Category;
import kr.ac.knu.CapstoneDesignProject2.entity.UserEntity;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.time.LocalDateTime;
import java.util.List;

@Getter
@Setter
@NoArgsConstructor
public class ChatRoomDTO {

    private int chatRoomId;
    private String chatRoomTitle;
    private int categoryId;
    private String categoryName;
    private int creatorId;
    private String creatorName;
    private List<String> tags;
    private LocalDateTime createAt;
    private LocalDateTime updateAt;

    public ChatRoomDTO(int chatRoomId, String chatRoomTitle, int categoryId, String categoryName, int creatorId, String creatorName,LocalDateTime createAt, LocalDateTime updateAt, List<String> tags) {
        this.chatRoomId = chatRoomId;
        this.chatRoomTitle = chatRoomTitle;
        this.categoryId = categoryId;
        this.categoryName = categoryName;
        this.creatorId = creatorId;
        this.creatorName = creatorName;
        this.tags = tags;
        this.createAt = createAt;
        this.updateAt = updateAt;
    }

}
