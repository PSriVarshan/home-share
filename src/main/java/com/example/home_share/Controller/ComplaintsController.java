package com.example.home_share.Controller;

import com.example.home_share.Model.ComplaintsModel;
import com.example.home_share.Service.ComplaintsService;

import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/complaints")
public class ComplaintsController {

    private final ComplaintsService complaintsService;

    public ComplaintsController(ComplaintsService complaintsService) {
        this.complaintsService = complaintsService;
    }

    @PostMapping("/add")
    public String addComplaint(
            @RequestParam Integer userId,
            @RequestParam Integer roomId,
            @RequestBody ComplaintsModel complaint) {
        return complaintsService.addComplaint(userId, roomId, complaint);
    }
}