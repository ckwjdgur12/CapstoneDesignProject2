package kr.ac.knu.CapstoneDesignProject2.service.Implements;

import kr.ac.knu.CapstoneDesignProject2.dao.ChatRoomRepository;
import kr.ac.knu.CapstoneDesignProject2.dao.MyChatRoomRepository;
import kr.ac.knu.CapstoneDesignProject2.dao.TagRepository;
import kr.ac.knu.CapstoneDesignProject2.dto.request.ChatRoomRequestDTO;
import kr.ac.knu.CapstoneDesignProject2.dto.response.ChatRoomDTO;
import kr.ac.knu.CapstoneDesignProject2.entity.*;
import kr.ac.knu.CapstoneDesignProject2.service.Interfaces.ChatRoomService;
import kr.ac.knu.CapstoneDesignProject2.service.Interfaces.ChatRoomTagService;
import kr.ac.knu.CapstoneDesignProject2.service.Interfaces.TagService;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
public class ChatRoomServiceImpl implements ChatRoomService {

    private ChatRoomRepository chatRoomRepository;
    private TagService tagService;
    private ChatRoomTagService chatRoomTagService;
    private MyChatRoomRepository myChatRoomRepository;

    public ChatRoomServiceImpl(ChatRoomRepository chatRoomRepository, TagService tagService, ChatRoomTagService chatRoomTagService, MyChatRoomRepository myChatRoomRepository) {
        this.chatRoomRepository = chatRoomRepository;
        this.tagService = tagService;
        this.chatRoomTagService = chatRoomTagService;
        this.myChatRoomRepository = myChatRoomRepository;
    }

    @Override
    public ChatRoomDTO findById(int theId) {

        Optional<ChatRoom> result = chatRoomRepository.findById(theId);

        ChatRoom theChatRoom = null;

        if (result.isPresent()) {
            theChatRoom = result.get();
        }
        else {
            // we didn't find the user
            throw new RuntimeException("Did not find chatRoom id - " + theId);
        }

        List<String> tagNames = chatRoomTagService.findByChatRoom(theChatRoom)
                .stream()
                .map(chatRoomTag -> chatRoomTag.getTheTag().getTag())
                .collect(Collectors.toList());

        return new ChatRoomDTO(
                theChatRoom.getChatRoomId(),
                theChatRoom.getChatRoomTitle(),
                theChatRoom.getTheCategory().getCategoryId(),
                theChatRoom.getTheCategory().getCategoryName(),
                theChatRoom.getTheUser().getUserEntityId(),
                theChatRoom.getTheUser().getName(),
                theChatRoom.getCreateAt(),
                theChatRoom.getUpdateAt(),
                tagNames
        );

    }

    @Override
    public ChatRoomDTO findByChatRoomTitle(String chatRoomTitle) {

        Optional<ChatRoom> result = chatRoomRepository.findByChatRoomTitle(chatRoomTitle);

        ChatRoom theChatRoom = null;

        if (result.isPresent()) {
            theChatRoom = result.get();
        }
        else {
            // we didn't find the user
            throw new RuntimeException("Did not find chatRoom - " + chatRoomTitle);
        }

        List<String> tagNames = chatRoomTagService.findByChatRoom(theChatRoom)
                .stream()
                .map(chatRoomTag -> chatRoomTag.getTheTag().getTag())
                .collect(Collectors.toList());

        return new ChatRoomDTO(
                theChatRoom.getChatRoomId(),
                theChatRoom.getChatRoomTitle(),
                theChatRoom.getTheCategory().getCategoryId(),
                theChatRoom.getTheCategory().getCategoryName(),
                theChatRoom.getTheUser().getUserEntityId(),
                theChatRoom.getTheUser().getName(),
                theChatRoom.getCreateAt(),
                theChatRoom.getUpdateAt(),
                tagNames
        );

    }

    @Override
    public ChatRoom save(ChatRoom theChatRoom) {
        return chatRoomRepository.save(theChatRoom);
    }

    @Override
    public ChatRoom addChatRoom(ChatRoomRequestDTO chatRoomRequestDTO){

        ChatRoom theChatRoom = new ChatRoom(
                chatRoomRequestDTO.getChatRoomTitle(),
                chatRoomRequestDTO.getTheCategory(),
                chatRoomRequestDTO.getTheUser()
        );

        theChatRoom = chatRoomRepository.save(theChatRoom);

        MyChatRoom myChatRoom = new MyChatRoom(
                theChatRoom.getTheUser(),
                theChatRoom,
                0
        );
        myChatRoomRepository.save(myChatRoom);

        for (String tag : chatRoomRequestDTO.getTags()){
            Tag existingTag = tagService.findByTag(tag);
            if (existingTag == null){
                existingTag = new Tag(tag);
                tagService.save(existingTag);
            }

            ChatRoomTag chatRoomTag = new ChatRoomTag(theChatRoom, existingTag);
            chatRoomTagService.save(chatRoomTag);
        }

        return theChatRoom;
    }

    @Override
    public ChatRoom updateChatRoom(int chatRoomId, ChatRoomRequestDTO chatRoomRequestDTO) {

        ChatRoom theChatRoom = chatRoomRepository.findById(chatRoomId)
                .orElseThrow(() -> new NullPointerException("해당 채팅방이 존재하지 않습니다."));

        if (chatRoomRequestDTO.getChatRoomTitle() != null) theChatRoom.setChatRoomTitle(chatRoomRequestDTO.getChatRoomTitle());
        if (chatRoomRequestDTO.getTags() != null) {
            chatRoomTagService.deleteByChatRoom(theChatRoom);

            for (String tag : chatRoomRequestDTO.getTags()){
                Tag existingTag = tagService.findByTag(tag);
                if (existingTag == null){
                    existingTag = new Tag(tag);
                    tagService.save(existingTag);
                }

                ChatRoomTag chatRoomTag = new ChatRoomTag(theChatRoom, existingTag);
                chatRoomTagService.save(chatRoomTag);
            }
        }

        return chatRoomRepository.save(theChatRoom);
    }

    @Override
    public void deleteById(int theId) {
        chatRoomRepository.deleteById(theId);
    }

    @Override
    public List<ChatRoomDTO> getAllChatRoomsOrderByUpdatedAt() {
        List<ChatRoom> chatRooms = chatRoomRepository.getAllChatRoomsOrderByUpdatedAt();

        return chatRooms.stream()
                .map(theChatRoom -> {
                    List<String> tagNames = theChatRoom.getChatRoomTags().stream()
                            .map(chatRoomTag -> chatRoomTag.getTheTag().getTag())
                            .collect(Collectors.toList());

                    return new ChatRoomDTO(
                            theChatRoom.getChatRoomId(),
                            theChatRoom.getChatRoomTitle(),
                            theChatRoom.getTheCategory().getCategoryId(),
                            theChatRoom.getTheCategory().getCategoryName(),
                            theChatRoom.getTheUser().getUserEntityId(),
                            theChatRoom.getTheUser().getName(),
                            theChatRoom.getCreateAt(),
                            theChatRoom.getUpdateAt(),
                            tagNames
                    );
                }).collect(Collectors.toList());
    }

    @Override
    public List<ChatRoomDTO> getChatRoomsByCategoryId(int categoryId) {
        Category theCategory = new Category();
        theCategory.setCategoryId(categoryId);
        List<ChatRoom> chatRooms = chatRoomRepository.findAllByTheCategoryOrderByUpdateAtDesc(theCategory);

        return chatRooms.stream()
                .map(theChatRoom -> {
                    List<String> tagNames = theChatRoom.getChatRoomTags().stream()
                            .map(chatRoomTag -> chatRoomTag.getTheTag().getTag())
                            .collect(Collectors.toList());

                    return new ChatRoomDTO(
                            theChatRoom.getChatRoomId(),
                            theChatRoom.getChatRoomTitle(),
                            theChatRoom.getTheCategory().getCategoryId(),
                            theChatRoom.getTheCategory().getCategoryName(),
                            theChatRoom.getTheUser().getUserEntityId(),
                            theChatRoom.getTheUser().getName(),
                            theChatRoom.getCreateAt(),
                            theChatRoom.getUpdateAt(),
                            tagNames
                    );
                }).collect(Collectors.toList());
    }
}
