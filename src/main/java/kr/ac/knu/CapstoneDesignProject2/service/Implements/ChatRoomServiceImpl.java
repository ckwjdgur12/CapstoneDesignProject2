package kr.ac.knu.CapstoneDesignProject2.service.Implements;

import kr.ac.knu.CapstoneDesignProject2.dao.ChatRoomRepository;
import kr.ac.knu.CapstoneDesignProject2.dto.ChatRoomDTO;
import kr.ac.knu.CapstoneDesignProject2.entity.Category;
import kr.ac.knu.CapstoneDesignProject2.entity.ChatRoom;
import kr.ac.knu.CapstoneDesignProject2.service.Interfaces.ChatRoomService;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
public class ChatRoomServiceImpl implements ChatRoomService {

    private ChatRoomRepository chatRoomRepository;

    public ChatRoomServiceImpl(ChatRoomRepository chatRoomRepository) {
        this.chatRoomRepository = chatRoomRepository;
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

        return new ChatRoomDTO(
                theChatRoom.getChatRoomId(),
                theChatRoom.getChatRoomTitle(),
                theChatRoom.getTheCategory().getCategoryId(),
                theChatRoom.getTheCategory().getCategoryName(),
                theChatRoom.getTheUser().getUserEntityId(),
                theChatRoom.getTheUser().getName(),
                theChatRoom.getCreateAt(),
                theChatRoom.getUpdateAt()
        );

    }

    @Override
    public ChatRoom save(ChatRoom theChatRoom) {
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
                .map(theChatRoom -> new ChatRoomDTO(
                        theChatRoom.getChatRoomId(),
                        theChatRoom.getChatRoomTitle(),
                        theChatRoom.getTheCategory().getCategoryId(),
                        theChatRoom.getTheCategory().getCategoryName(),
                        theChatRoom.getTheUser().getUserEntityId(),
                        theChatRoom.getTheUser().getName(),
                        theChatRoom.getCreateAt(),
                        theChatRoom.getUpdateAt()
                )).collect(Collectors.toList());
    }

    @Override
    public List<ChatRoomDTO> getChatRoomsByCategoryId(int categoryId) {
        Category theCategory = new Category();
        theCategory.setCategoryId(categoryId);
        List<ChatRoom> chatRooms = chatRoomRepository.findAllByTheCategoryOrderByUpdateAtDesc(theCategory);

        return chatRooms.stream()
                .map(theChatRoom -> new ChatRoomDTO(
                        theChatRoom.getChatRoomId(),
                        theChatRoom.getChatRoomTitle(),
                        theChatRoom.getTheCategory().getCategoryId(),
                        theChatRoom.getTheCategory().getCategoryName(),
                        theChatRoom.getTheUser().getUserEntityId(),
                        theChatRoom.getTheUser().getName(),
                        theChatRoom.getCreateAt(),
                        theChatRoom.getUpdateAt()
                )).collect(Collectors.toList());
    }
}
