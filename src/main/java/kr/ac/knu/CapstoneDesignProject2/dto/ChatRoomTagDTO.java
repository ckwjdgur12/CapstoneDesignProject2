package kr.ac.knu.CapstoneDesignProject2.dto;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
public class ChatRoomTagDTO {

    private int tagTableId;
    private int chatRoomId;
    private String chatRoomTitle;
    private int tagId;
    private String tag;

    public ChatRoomTagDTO(int tagTableId, int chatRoomId, String chatRoomTitle, int tagId, String tag) {
        this.tagTableId = tagTableId;
        this.chatRoomId = chatRoomId;
        this.chatRoomTitle = chatRoomTitle;
        this.tagId = tagId;
        this.tag = tag;
    }
}
