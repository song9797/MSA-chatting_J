package com.example.userkicker.repository;

import com.example.userkicker.model.RoomUser;
import com.example.userkicker.model.RoomUserID;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface RoomUserRepository extends CrudRepository<RoomUser, RoomUserID> {
    void deleteByRoomIdAndRoomUserId(String roomId, String userId);
}
