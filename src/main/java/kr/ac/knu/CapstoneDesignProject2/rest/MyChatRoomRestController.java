package kr.ac.knu.CapstoneDesignProject2.rest;

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
    public List<MyChatRoom> findAll() {
        return myChatRoomService.findAll();
    }

    @GetMapping("/mychatrooms/{myChatRoomId}")
    public MyChatRoom getMyChatRoom(@PathVariable int myChatRoomId) {

        MyChatRoom theMyChatRoom = myChatRoomService.findById(myChatRoomId);

        if (theMyChatRoom == null) {
            throw new MyNotFoundException("MyChatRoom id not found - " + myChatRoomId);
        }

        return theMyChatRoom;
    }

    @PostMapping("/mychatrooms")
    public MyChatRoom addMyChatRoom(@RequestBody MyChatRoom theMyChatRoom){
        theMyChatRoom.setMyChatRoomTableId(0);
        MyChatRoom dbMyChatRoom = myChatRoomService.save(theMyChatRoom);
        return dbMyChatRoom;
    }

    @PutMapping("/mychatrooms")
    public MyChatRoom updateMyChatRoom(@RequestBody MyChatRoom theMyChatRoom) {

        MyChatRoom dbMyChatRoom = myChatRoomService.save(theMyChatRoom);

        return dbMyChatRoom;
    }

    @DeleteMapping("/mychatrooms/{myChatRoomId}")
    public String deleteMyChatRoom(@PathVariable int myChatRoomId) {

        MyChatRoom tmpMyChatRoom = myChatRoomService.findById(myChatRoomId);

        if (tmpMyChatRoom == null) {
            throw new MyNotFoundException("MyChatRoom id not found - " + myChatRoomId);
        }

        myChatRoomService.deleteById(myChatRoomId);

        return "Deleted myChatRoom Id - " + myChatRoomId;
    }

}
