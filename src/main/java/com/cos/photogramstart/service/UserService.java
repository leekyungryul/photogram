package com.cos.photogramstart.service;

import java.util.function.Supplier;

import javax.transaction.Transactional;

import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

import com.cos.photogramstart.domain.user.User;
import com.cos.photogramstart.domain.user.UserRepository;
import com.cos.photogramstart.hander.ex.CustomValidationApiException;

import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor
@Service
public class UserService {

    private final UserRepository userRepository;

    private final BCryptPasswordEncoder bCryptPasswordEncoder;

    @Transactional
    public User update(int id, User user) {
        // 1. 영속화
        User userEntity = userRepository.findById(id).orElseThrow(() -> new CustomValidationApiException("회원 찾기 실패"));
        // 2. 영속화된 오브젝트를 수정 - 더티체킹 (업데이트 완료)
        userEntity.setName(user.getName());
        userEntity.setPassword(bCryptPasswordEncoder.encode(user.getPassword()));
        userEntity.setWebsite(user.getWebsite());
        userEntity.setBio(user.getBio());
        userEntity.setPhone(user.getPhone());
        userEntity.setGender(user.getGender());

        return userEntity;
    }
}
