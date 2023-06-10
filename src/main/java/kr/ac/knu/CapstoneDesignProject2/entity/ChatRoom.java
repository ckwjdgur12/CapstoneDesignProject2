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
import java.util.HashSet;
import java.util.List;
import java.util.Set;

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

    @OneToMany(mappedBy = "chatRoom", cascade = CascadeType.ALL)
    private List<ChatRoomTag> chatRoomTags;

    public ChatRoom() {

    }

    public ChatRoom(String chatRoomTitle, Category theCategory, UserEntity theUser) {
        this.chatRoomTitle = chatRoomTitle;
        this.theCategory = theCategory;
        this.theUser = theUser;
    }

}

