package kr.ac.knu.CapstoneDesignProject2.entity;

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;
import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.UpdateTimestamp;

import java.time.LocalDateTime;

@Entity
@Table(name="ChatRoom")
@Getter
@Setter
@ToString
public class ChatRoom {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name="chatRoomId")
    private int chatRoomId;

    @Column(name="chatRoomTitle")
    private String chatRoomTitle;

    @Column(name="tag")
    private String tag;

    @CreationTimestamp
    @Column(name = "createAt", updatable = false)
    private LocalDateTime createAt;

    @UpdateTimestamp
    @Column(name = "updateAt")
    private LocalDateTime updateAt;

    @ManyToOne
    @JoinColumn(name="categoryId")
    // @JsonIgnore
    private Category theCategory;

    @ManyToOne
    @JoinColumn(name="userId")
    // @JsonIgnore
    private UserEntity theUser;

    public ChatRoom() {

    }

    public ChatRoom(String chatRoomTitle, Category theCategory, UserEntity theUser) {
        this.chatRoomTitle = chatRoomTitle;
        this.theCategory = theCategory;
        this.theUser = theUser;
    }

    public ChatRoom(String chatRoomTitle, Category theCategory, UserEntity theUser, String theTag) {
        this.chatRoomTitle = chatRoomTitle;
        this.theCategory = theCategory;
        this.theUser = theUser;
        this.tag = theTag;
    }

}

