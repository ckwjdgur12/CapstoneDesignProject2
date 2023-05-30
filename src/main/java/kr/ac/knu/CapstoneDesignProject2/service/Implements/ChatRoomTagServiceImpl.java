package kr.ac.knu.CapstoneDesignProject2.service.Implements;

import kr.ac.knu.CapstoneDesignProject2.dao.ChatRoomTagRepository;
import kr.ac.knu.CapstoneDesignProject2.dto.ChatRoomTagDTO;
import kr.ac.knu.CapstoneDesignProject2.entity.ChatRoomTag;
import kr.ac.knu.CapstoneDesignProject2.service.Interfaces.ChatRoomTagService;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
public class ChatRoomTagServiceImpl implements ChatRoomTagService {

    private ChatRoomTagRepository chatRoomTagRepository;

    public ChatRoomTagServiceImpl(ChatRoomTagRepository chatRoomTagRepository) {
        this.chatRoomTagRepository = chatRoomTagRepository;
    }

    @Override
    public List<ChatRoomTagDTO> findAll() {

        List<ChatRoomTag> chatRoomTags = chatRoomTagRepository.findAll();

        return chatRoomTags.stream()
                .map(theChatRoomTag -> new ChatRoomTagDTO(
                    theChatRoomTag.getTagTableId(),
                    theChatRoomTag.getTheChatRoom().getChatRoomId(),
                    theChatRoomTag.getTheChatRoom().getChatRoomTitle(),
                    theChatRoomTag.getTheTag().getTagId(),
                    theChatRoomTag.getTheTag().getTag()
                )).collect(Collectors.toList());
    }

    @Override
    public ChatRoomTagDTO findById(int theId) {

        Optional<ChatRoomTag> result = chatRoomTagRepository.findById(theId);

        ChatRoomTag theChatRoomTag = null;

        if (result.isPresent()) {
            theChatRoomTag = result.get();
        }
        else {
            // we didn't find the user
            throw new RuntimeException("Did not find chatRoomTag id - " + theId);
        }

        return new ChatRoomTagDTO(
                theChatRoomTag.getTagTableId(),
                theChatRoomTag.getTheChatRoom().getChatRoomId(),
                theChatRoomTag.getTheChatRoom().getChatRoomTitle(),
                theChatRoomTag.getTheTag().getTagId(),
                theChatRoomTag.getTheTag().getTag()
        );
    }

    @Override
    public ChatRoomTag save(ChatRoomTag theChatRoomTag) {
        return chatRoomTagRepository.save(theChatRoomTag);
    }

    @Override
    public void deleteById(int theId) {
        chatRoomTagRepository.deleteById(theId);
    }


}
