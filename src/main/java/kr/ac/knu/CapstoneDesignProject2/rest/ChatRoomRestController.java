package kr.ac.knu.CapstoneDesignProject2.rest;

import kr.ac.knu.CapstoneDesignProject2.dto.request.ChatRoomRequestDTO;
import kr.ac.knu.CapstoneDesignProject2.dto.response.ChatRoomDTO;
import kr.ac.knu.CapstoneDesignProject2.entity.ChatRoom;
import kr.ac.knu.CapstoneDesignProject2.rest.exceptionHandler.MyNotFoundException;
import kr.ac.knu.CapstoneDesignProject2.service.Interfaces.ChatRoomService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api")
public class ChatRoomRestController {

    private ChatRoomService chatRoomService;

    @Autowired
    public ChatRoomRestController(ChatRoomService chatRoomService) {
        this.chatRoomService = chatRoomService;
    }

    @GetMapping("/chatrooms")
    public List<ChatRoomDTO> getAllChatRoomsOrderByUpdatedAt() {
        return chatRoomService.getAllChatRoomsOrderByUpdatedAt();
    }

    @GetMapping("/chatrooms/categories/{categoryId}")
    public List<ChatRoomDTO> getChatRoomsByCategoryId(@PathVariable int categoryId) {
        return chatRoomService.getChatRoomsByCategoryId(categoryId);
    }

    @GetMapping("/chatrooms/{chatRoomId}")
    public ChatRoomDTO getChatRoom(@PathVariable int chatRoomId) {

        ChatRoomDTO theChatRoom = chatRoomService.findById(chatRoomId);

        if (theChatRoom == null) {
            throw new MyNotFoundException("ChatRoom id not found - " + chatRoomId);
        }

        return theChatRoom;
    }

    @GetMapping("/chatrooms/search/{chatRoomTitle}")
    public ChatRoomDTO getChatRoom(@PathVariable String chatRoomTitle) {

        ChatRoomDTO theChatRoom = chatRoomService.findByChatRoomTitle(chatRoomTitle);

        if (theChatRoom == null) {
            throw new MyNotFoundException("ChatRoom not found - " + chatRoomTitle);
        }

        return theChatRoom;
    }

    @PostMapping("/chatrooms")
    public ChatRoom addChatRoom(@RequestBody ChatRoomRequestDTO chatRoomRequestDTO){
        ChatRoom dbChatRoom = chatRoomService.addChatRoom(chatRoomRequestDTO);
        return dbChatRoom;
    }

    @PatchMapping("/chatrooms/{chatRoomId}")
    public ChatRoom updateChatRoom(@PathVariable int chatRoomId, @RequestBody ChatRoomRequestDTO chatRoomRequestDTO) {
        ChatRoom dbChatRoom = chatRoomService.updateChatRoom(chatRoomId, chatRoomRequestDTO);
        return dbChatRoom;
    }

    @DeleteMapping("/chatrooms/{chatRoomId}")
    public String deleteChatRoom(@PathVariable int chatRoomId) {

        ChatRoomDTO tmpChatRoom = chatRoomService.findById(chatRoomId);

        if (tmpChatRoom == null) {
            throw new MyNotFoundException("ChatRoom id not found - " + chatRoomId);
        }

        chatRoomService.deleteById(chatRoomId);

        return "Deleted chatRoom Id - " + chatRoomId;
    }

}
