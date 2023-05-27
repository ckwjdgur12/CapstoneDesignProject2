package kr.ac.knu.CapstoneDesignProject2.dto;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
public class CategoryDTO {

    private int categoryId;
    private String categoryName;
    private int chatRoomCount;

    public CategoryDTO(int categoryId, String categoryName, int chatRoomCount) {
        this.categoryId = categoryId;
        this.categoryName = categoryName;
        this.chatRoomCount = chatRoomCount;
    }

}
