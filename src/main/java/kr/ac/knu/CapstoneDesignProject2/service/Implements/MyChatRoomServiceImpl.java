package kr.ac.knu.CapstoneDesignProject2.service.Implements;

import kr.ac.knu.CapstoneDesignProject2.dao.MyChatRoomRepository;
import kr.ac.knu.CapstoneDesignProject2.entity.MyChatRoom;
import kr.ac.knu.CapstoneDesignProject2.service.Interfaces.MyChatRoomService;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class MyChatRoomServiceImpl implements MyChatRoomService {

    private MyChatRoomRepository myChatRoomRepository;

    public MyChatRoomServiceImpl(MyChatRoomRepository myChatRoomRepository) {
        this.myChatRoomRepository = myChatRoomRepository;
    }

    @Override
    public List<MyChatRoom> findAll() {
        return myChatRoomRepository.findAll();
    }

    @Override
    public MyChatRoom findById(int theId) {

        Optional<MyChatRoom> result = myChatRoomRepository.findById(theId);

        MyChatRoom theMyChatRoom = null;

        if (result.isPresent()) {
            theMyChatRoom = result.get();
        }
        else {
            // we didn't find the user
            throw new RuntimeException("Did not find myChatRoom id - " + theId);
        }

        return theMyChatRoom;

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
