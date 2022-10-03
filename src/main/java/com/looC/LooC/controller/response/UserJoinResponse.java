package com.looC.LooC.controller.response;

import com.looC.LooC.model.User;
import com.looC.LooC.model.entity.UserRole;
import lombok.AllArgsConstructor;
import lombok.Getter;

import javax.management.relation.Role;
import javax.persistence.criteria.CriteriaBuilder;

@AllArgsConstructor
@Getter
public class UserJoinResponse {

    private String userName;
    private Integer Id;
    private UserRole role;

    public static UserJoinResponse fromUser(User user){
        return new UserJoinResponse(
            user.getUserName(),
            user.getId(),
            user.getUserRole()
        );
    }
}
