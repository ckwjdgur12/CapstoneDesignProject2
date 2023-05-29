package kr.ac.knu.CapstoneDesignProject2.entity;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@Entity
@Table(name="MyChatRoom")
@Getter
@Setter
@ToString
public class MyChatRoom {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name="myChatRoomTableId")
    private int myChatRoomTableId;

    @ManyToOne
    @JoinColumn(name="userEntityId")
    // @JsonIgnore
    private UserEntity theUserEntity;

    @ManyToOne
    @JoinColumn(name="chatroomId")
    // @JsonIgnore
    private ChatRoom theChatRoom;

    @Column(name = "lastChatId")
    private int lastChatId;

    public MyChatRoom() {

    }

    public MyChatRoom(UserEntity theUserEntity, ChatRoom theChatRoom, int lastChatId) {
        this.theUserEntity = theUserEntity;
        this.theChatRoom = theChatRoom;
        this.lastChatId = lastChatId;
    }

}

