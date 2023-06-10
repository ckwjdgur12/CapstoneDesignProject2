package kr.ac.knu.CapstoneDesignProject2.rest;

import kr.ac.knu.CapstoneDesignProject2.dto.response.MyChatRoomDTO;
import kr.ac.knu.CapstoneDesignProject2.entity.MyChatRoom;
import kr.ac.knu.CapstoneDesignProject2.rest.exceptionHandler.MyNotFoundException;
import kr.ac.knu.CapstoneDesignProject2.service.Interfaces.MyChatRoomService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api")
public class MyChatRoomRestController {

    private MyChatRoomService myChatRoomService;

    @Autowired
    public MyChatRoomRestController(MyChatRoomService myChatRoomService) {
        this.myChatRoomService = myChatRoomService;
    }

    @GetMapping("/mychatrooms")
    public List<MyChatRoomDTO> findAll() {
        return myChatRoomService.findAll();
    }

    @GetMapping("/mychatrooms/{myChatRoomId}")
    public MyChatRoomDTO getMyChatRoom(@PathVariable int myChatRoomId) {

        MyChatRoomDTO theMyChatRoom = myChatRoomService.findById(myChatRoomId);

        if (theMyChatRoom == null) {
            throw new MyNotFoundException("MyChatRoom id not found - " + myChatRoomId);
        }

        return theMyChatRoom;
    }

    @GetMapping("/mychatrooms/user/{userEntityId}")
    public List<MyChatRoomDTO> getMyChatRoomByUser(@PathVariable int userEntityId) {
        return myChatRoomService.findByUserEntity(userEntityId);
    }

    @PostMapping("/mychatrooms")
    public MyChatRoomDTO addMyChatRoom(@RequestBody MyChatRoom theMyChatRoom){
        theMyChatRoom.setMyChatRoomTableId(0);
        MyChatRoom dbMyChatRoom = myChatRoomService.save(theMyChatRoom);
        return myChatRoomService.findById(dbMyChatRoom.getMyChatRoomTableId());
    }

    @PutMapping("/mychatrooms")
    public MyChatRoomDTO updateMyChatRoom(@RequestBody MyChatRoom theMyChatRoom) {

        MyChatRoom dbMyChatRoom = myChatRoomService.save(theMyChatRoom);

        return myChatRoomService.findById(dbMyChatRoom.getMyChatRoomTableId());
    }

    @DeleteMapping("/mychatrooms/{myChatRoomId}")
    public String deleteMyChatRoom(@PathVariable int myChatRoomId) {

        MyChatRoomDTO tmpMyChatRoom = myChatRoomService.findById(myChatRoomId);

        if (tmpMyChatRoom == null) {
            throw new MyNotFoundException("MyChatRoom id not found - " + myChatRoomId);
        }

        myChatRoomService.deleteById(myChatRoomId);

        return "Deleted myChatRoom Id - " + myChatRoomId;
    }

}
