package com.example.messagesubscriber.repository;

import java.util.List;

import com.example.messagesubscriber.model.RoomUser;
import com.example.messagesubscriber.model.RoomUserId;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface RoomUserRepository extends CrudRepository<RoomUser, RoomUserId> {
    List<RoomUser> findByRoomIdAndUserId(String roomId, String userId);
    List<RoomUser> findByRoomId(String roomId);
}
