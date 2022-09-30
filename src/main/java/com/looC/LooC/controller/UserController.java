package com.looC.LooC.controller;

import com.looC.LooC.controller.request.UserJoinRequest;
import com.looC.LooC.service.UserService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/vc1/user")
@RequiredArgsConstructor
public class UserController {

    private final UserService userService;


    @PostMapping("/join")
    public void join(@RequestBody UserJoinRequest request){
        userService.join(request.getUserName(), request.getPassword() );
    }


}
