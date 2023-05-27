package kr.ac.knu.CapstoneDesignProject2.entity;

import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

import java.util.List;

@Entity
@Table(name="Category")
@Getter
@Setter
@ToString
public class Category {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name="categoryId")
    private int categoryId;

    @Column(name="categoryName")
    private String categoryName;

    @OneToMany(mappedBy = "theCategory")
    @JsonIgnore
    private List<ChatRoom> chatRooms;

    public Category() {

    }

    public Category(String categoryName) {
        this.categoryName = categoryName;
    }

}
