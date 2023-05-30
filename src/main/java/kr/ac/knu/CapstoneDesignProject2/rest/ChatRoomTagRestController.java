package kr.ac.knu.CapstoneDesignProject2.rest;

import kr.ac.knu.CapstoneDesignProject2.dto.ChatRoomTagDTO;
import kr.ac.knu.CapstoneDesignProject2.entity.ChatRoomTag;
import kr.ac.knu.CapstoneDesignProject2.rest.exceptionHandler.MyNotFoundException;
import kr.ac.knu.CapstoneDesignProject2.service.Interfaces.ChatRoomTagService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api")
public class ChatRoomTagRestController {

    private ChatRoomTagService chatRoomTagService;

    @Autowired
    public ChatRoomTagRestController(ChatRoomTagService chatRoomTagService) {
        this.chatRoomTagService = chatRoomTagService;
    }

    @GetMapping("/chatroomtags")
    public List<ChatRoomTagDTO> findAll() {
        return chatRoomTagService.findAll();
    }

    @GetMapping("/chatroomtags/{chatRoomTagId}")
    public ChatRoomTagDTO getChatRoomTag(@PathVariable int chatRoomTagId) {

        ChatRoomTagDTO theChatRoomTag = chatRoomTagService.findById(chatRoomTagId);

        if (theChatRoomTag == null) {
            throw new MyNotFoundException("ChatRoomTag id not found - " + chatRoomTagId);
        }

        return theChatRoomTag;
    }

    @PostMapping("/chatroomtags")
    public ChatRoomTag addChatRoomTag(@RequestBody ChatRoomTag theChatRoomTag){
        theChatRoomTag.setTagTableId(0);
        ChatRoomTag dbChatRoomTag = chatRoomTagService.save(theChatRoomTag);
        return dbChatRoomTag;
    }

    @PutMapping("/chatroomtags")
    public ChatRoomTag updateChatRoomTag(@RequestBody ChatRoomTag theChatRoomTag) {

        ChatRoomTag dbChatRoomTag = chatRoomTagService.save(theChatRoomTag);

        return dbChatRoomTag;
    }

    @DeleteMapping("/chatroomtags/{chatRoomTagId}")
    public String deleteChatRoomTag(@PathVariable int chatRoomTagId) {

        ChatRoomTagDTO tmpChatRoomTag = chatRoomTagService.findById(chatRoomTagId);

        if (tmpChatRoomTag == null) {
            throw new MyNotFoundException("ChatRoomTag id not found - " + chatRoomTagId);
        }

        chatRoomTagService.deleteById(chatRoomTagId);

        return "Deleted chatRoomTag Id - " + chatRoomTagId;
    }

}
