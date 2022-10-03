package com.looC.LooC.model;

import com.looC.LooC.model.entity.UserEntity;
import com.looC.LooC.model.entity.UserRole;
import lombok.AllArgsConstructor;
import lombok.Getter;

import java.sql.Time;
import java.sql.Timestamp;

@Getter
@AllArgsConstructor
public class User {
    private String userName;
    private String password;
    private Integer id;
    private UserRole userRole;
    private Timestamp registeredAt;
    private Timestamp updatedAt;
    private Timestamp deletedAt;
    public static User fromEntity(UserEntity userEntity){
        return new User(
                userEntity.getUserName(),
                userEntity.getPassword(),
                userEntity.getId(),
                userEntity.getRole(),
                userEntity.getRegisteredAt(),
                userEntity.getUpdatedAt(),
                userEntity.getDeletedAt()
        );
    }
}
