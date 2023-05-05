package kr.ac.knu.CapstoneDesignProject2.entity;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@Entity
@Table(name="Tag")
@Getter
@Setter
@ToString
public class Tag {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name="tagId")
    private int tagId;

    @Column(name="tag")
    private String tag;

    public Tag() {

    }

    public Tag(String tag) {
        this.tag = tag;
    }

}
