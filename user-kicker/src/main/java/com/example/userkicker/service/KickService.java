package com.example.userkicker.service;

import javax.transaction.Transactional;

import com.example.userkicker.repository.RoomUserRepository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import lombok.extern.slf4j.Slf4j;

@Slf4j
@Service
@Transactional
public class KickService {
    @Autowired
    private RoomUserRepository roomUserRepository;

    public void kickByRoomIdAndUserId(String roomId, String userId){
        // RoomUserID roomUserId = new RoomUserID(roomId, userId);
        roomUserRepository.deleteByRoomIdAndUserId(roomId, userId);
    }
}
