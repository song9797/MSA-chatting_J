package com.example.userkicker.controller;

import com.example.userkicker.DTO.ResponseDTO;
import com.example.userkicker.service.KickService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@Controller
@RequestMapping(value = "/kick")
public class KickController {
    @Autowired
    private KickService kickService;

    @RequestMapping(value = "/{roomId}/{userId}/", method = RequestMethod.DELETE)
    public ResponseEntity<?> kickUser(@PathVariable String roomId, @PathVariable String userId){
        kickService.kickByRoomIdAndUserId(roomId, userId);
        return ResponseEntity.ok().body(new ResponseDTO(200, "kicked", null));
    }
    
}
