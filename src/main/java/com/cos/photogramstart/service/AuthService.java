package com.cos.photogramstart.service;

import javax.transaction.Transactional;

import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

import com.cos.photogramstart.domain.user.User;
import com.cos.photogramstart.domain.user.UserRepository;

import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor
@Service // IoC 등록 (메모리에 띄움) -> IoC를 하려면 @Service, @Repository, @Configuration, @Controller, @Component 등을 붙여줘야 함
public class AuthService {

    private final UserRepository userRepository;
    private final BCryptPasswordEncoder bCryptPasswordEncoder;

    @Transactional // Write(Insert, Update, Delete)할 때는 @Transactional을 붙여줘야 함
    public User signup(User user) {
        String rawPassword = user.getPassword();
        String encPassword = bCryptPasswordEncoder.encode(rawPassword);
        user.setPassword(encPassword);
        user.setRole("ROLE_USER");
        User userEntity = userRepository.save(user);
        return userEntity;
    }
}
