package kr.ac.knu.CapstoneDesignProject2.service.Implements;

import kr.ac.knu.CapstoneDesignProject2.dao.MyChatRoomRepository;
import kr.ac.knu.CapstoneDesignProject2.dao.UserEntityRepository;
import kr.ac.knu.CapstoneDesignProject2.dto.response.ChatRoomDTO;
import kr.ac.knu.CapstoneDesignProject2.dto.response.MyChatRoomDTO;
import kr.ac.knu.CapstoneDesignProject2.entity.MyChatRoom;
import kr.ac.knu.CapstoneDesignProject2.entity.UserEntity;
import kr.ac.knu.CapstoneDesignProject2.service.Interfaces.ChatRoomService;
import kr.ac.knu.CapstoneDesignProject2.service.Interfaces.MyChatRoomService;
import org.apache.catalina.User;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
public class MyChatRoomServiceImpl implements MyChatRoomService {

    private MyChatRoomRepository myChatRoomRepository;
    private UserEntityRepository userEntityRepository;
    private ChatRoomService chatRoomService;

    public MyChatRoomServiceImpl(MyChatRoomRepository myChatRoomRepository, UserEntityRepository userEntityRepository, ChatRoomService chatRoomService) {
        this.myChatRoomRepository = myChatRoomRepository;
        this.userEntityRepository = userEntityRepository;
        this.chatRoomService = chatRoomService;
    }

    @Override
    public List<MyChatRoomDTO> findAll() {
        List<MyChatRoom> myChatRooms = myChatRoomRepository.findAll();

        return myChatRooms.stream()
                .map(myChatRoom -> new MyChatRoomDTO(
                        myChatRoom.getTheUserEntity().getUserEntityId(),
                        chatRoomService.findById(myChatRoom.getTheChatRoom().getChatRoomId()),
                        myChatRoom.getLastChatId()
                ))
                .collect(Collectors.toList());
    }

    @Override
    public MyChatRoomDTO findById(int theId) {

        Optional<MyChatRoom> result = myChatRoomRepository.findById(theId);

        MyChatRoom theMyChatRoom = null;

        if (result.isPresent()) {
            theMyChatRoom = result.get();
        }
        else {
            // we didn't find the user
            throw new RuntimeException("Did not find myChatRoom id - " + theId);
        }

        return new MyChatRoomDTO(
                theMyChatRoom.getTheUserEntity().getUserEntityId(),
                chatRoomService.findById(theMyChatRoom.getTheChatRoom().getChatRoomId()),
                theMyChatRoom.getLastChatId());

    }

    public List<MyChatRoomDTO> findByUserEntity(int userEntityId){
        Optional<UserEntity> result = userEntityRepository.findById(userEntityId);

        UserEntity userEntity;

        if (result.isPresent()) {
            userEntity = result.get();
        }
        else {
            // we didn't find the user
            throw new RuntimeException("Did not find userEntity id - " + userEntityId);
        }

        List<MyChatRoom> myChatRooms = myChatRoomRepository.findByTheUserEntity(userEntity);

        return myChatRooms.stream()
                .map(myChatRoom -> new MyChatRoomDTO(
                        userEntity.getUserEntityId(),
                        chatRoomService.findById(myChatRoom.getTheChatRoom().getChatRoomId()),
                        myChatRoom.getLastChatId()
                ))
                .collect(Collectors.toList());
    }

    @Override
    public MyChatRoom save(MyChatRoom theMyChatRoom) {
        return myChatRoomRepository.save(theMyChatRoom);
    }

    @Override
    public void deleteById(int theId) {
        myChatRoomRepository.deleteById(theId);
    }


}
