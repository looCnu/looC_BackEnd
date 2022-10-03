package com.looC.LooC.controller;

import com.looC.LooC.controller.request.UserJoinRequest;
import com.looC.LooC.controller.response.Response;
import com.looC.LooC.controller.response.UserJoinResponse;
import com.looC.LooC.model.User;
import com.looC.LooC.service.UserService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/v1/users")
@RequiredArgsConstructor
public class UserController {

    private final UserService userService;
    @PostMapping("/join")
    public Response<UserJoinResponse> join(@RequestBody UserJoinRequest request){
       User user = userService.join(request.getName(), request.getPassword());
       return Response.success( UserJoinResponse.fromUser(user));
    }


}
