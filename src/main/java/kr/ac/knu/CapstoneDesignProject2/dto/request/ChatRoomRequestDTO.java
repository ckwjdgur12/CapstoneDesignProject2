package kr.ac.knu.CapstoneDesignProject2.dto.request;

import kr.ac.knu.CapstoneDesignProject2.entity.Category;
import kr.ac.knu.CapstoneDesignProject2.entity.UserEntity;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.List;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class ChatRoomRequestDTO {

    private String chatRoomTitle;
    private Category theCategory;
    private UserEntity theUser;
    private List<String> tags;

}
