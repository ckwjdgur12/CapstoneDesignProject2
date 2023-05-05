package kr.ac.knu.CapstoneDesignProject2.service.Implements;

import kr.ac.knu.CapstoneDesignProject2.dao.ChatRoomRepository;
import kr.ac.knu.CapstoneDesignProject2.entity.ChatRoom;
import kr.ac.knu.CapstoneDesignProject2.service.Interfaces.ChatRoomService;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class ChatRoomServiceImpl implements ChatRoomService {

    private ChatRoomRepository chatRoomRepository;

    public ChatRoomServiceImpl(ChatRoomRepository chatRoomRepository) {
        this.chatRoomRepository = chatRoomRepository;
    }

    @Override
    public List<ChatRoom> findAll() {
        return chatRoomRepository.findAll();
    }

    @Override
    public ChatRoom findById(int theId) {

        Optional<ChatRoom> result = chatRoomRepository.findById(theId);

        ChatRoom theChatRoom = null;

        if (result.isPresent()) {
            theChatRoom = result.get();
        }
        else {
            // we didn't find the user
            throw new RuntimeException("Did not find chatRoom id - " + theId);
        }

        return theChatRoom;

    }

    @Override
    public ChatRoom save(ChatRoom theChatRoom) {
        return chatRoomRepository.save(theChatRoom);
    }

    @Override
    public void deleteById(int theId) {
        chatRoomRepository.deleteById(theId);
    }


}
