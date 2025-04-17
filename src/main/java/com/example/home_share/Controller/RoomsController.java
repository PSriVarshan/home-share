package com.example.home_share.Controller;

import org.springframework.web.bind.annotation.RestController;

import com.example.home_share.Data.RoomsDTO;
import com.example.home_share.Model.RoomsModel;
import com.example.home_share.Service.RoomsService;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;

import java.util.List;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.PathVariable;

@RestController
@RequestMapping("/rooms")
public class RoomsController {
    RoomsService roomsService;

    public RoomsController(RoomsService roomsService) {
        this.roomsService = roomsService;
    }

    @PostMapping("/add")
    public RoomsModel addRoom(@RequestBody RoomsModel rom) {
        return roomsService.addRoom(rom);
    }

    @GetMapping("/roomDetails")
    public RoomsDTO getMethodName(@RequestParam Integer id) {
        return roomsService.getFullRoomDetails(id);
    }

    @GetMapping("/city")
    public List<RoomsModel> listAllRooms(@RequestParam String param) {
        return roomsService.theRoomsInTheCity(param);
    }

    @PutMapping("/avl/{id}")
    public String avlStatusManager(@PathVariable Integer id, @RequestBody Boolean availabiltyBoolean) {
        int val = roomsService.updateRoomAvl(id, availabiltyBoolean);
        if (val < 1)
            return "Something went Wrong!!! ";
        return "Your room availabilty status is updated";
    }
}
