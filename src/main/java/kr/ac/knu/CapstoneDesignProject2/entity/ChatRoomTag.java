package kr.ac.knu.CapstoneDesignProject2.entity;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;
import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.UpdateTimestamp;

import java.time.LocalDateTime;

@Entity
@Table(name="ChatRoomTag")
@Getter
@Setter
@ToString
public class ChatRoomTag {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name="tagTableId")
    private int tagTableId;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name="chatRoomId")
    // @JsonIgnore
    private ChatRoom chatRoom;

    @ManyToOne
    @JoinColumn(name="tagId")
    // @JsonIgnore
    private Tag theTag;

    public ChatRoomTag() {

    }

    public ChatRoomTag(ChatRoom theChatRoom, Tag theTag) {
        this.chatRoom = theChatRoom;
        this.theTag = theTag;
    }

}

