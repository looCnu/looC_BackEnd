package com.looC.LooC.service;


import com.looC.LooC.exception.ErrorCode;
import com.looC.LooC.exception.LoocApplicationException;
import com.looC.LooC.model.User;
import com.looC.LooC.model.entity.UserEntity;
import com.looC.LooC.respository.UserEntityRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.Optional;

@Service
@RequiredArgsConstructor
public class UserService {

    private final UserEntityRepository userEntityRepository;

    private final BCryptPasswordEncoder encoder;

    @Transactional
    public User join(String userName, String password){

        //아이디 중복 검사
        userEntityRepository.findByUserName(userName).ifPresent(it -> {
            throw new LoocApplicationException(ErrorCode.DUPLICATED_USER_NAME, String.format("%s is duplicated", userName));
        });

        //화원가입 진행행
       UserEntity userEntity = userEntityRepository.save(UserEntity.of(userName, encoder.encode(password)));

       return User.fromEntity(userEntity);
    }
    public String login(String userName, String password) {
        // 회원 가입 체크
        UserEntity userEntity = userEntityRepository.findByUserName(userName).orElseThrow(()-> new LoocApplicationException(ErrorCode.DUPLICATED_USER_NAME, ""));
        // 비밀번호 체크

        if(!userEntity.getPassword().equals(password))
        {
            throw new LoocApplicationException(ErrorCode.DUPLICATED_USER_NAME, "");
        }

        // 토큰 생성


        return "";
    }
}
