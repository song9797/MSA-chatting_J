package com.example.userkicker.model;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.IdClass;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@IdClass(RoomUserID.class)
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class RoomUser {
    @Id
    private String roomId;
    @Id
    private String userId;
    private String auth;
}
