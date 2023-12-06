package com.cos.photogramstart.config.auth;

import org.slf4j.Logger;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import com.cos.photogramstart.domain.user.User;
import com.cos.photogramstart.domain.user.UserRepository;

import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor
@Service // IoC 등록
public class PrincipalDetailsService implements UserDetailsService {

    Logger logger = org.slf4j.LoggerFactory.getLogger(PrincipalDetailsService.class);

    private final UserRepository userRepository;

    // 1. 패스워드는 알아서 체킹하니까 신경쓸 필요 없음
    // 2. 리턴이 잘되면 자동으로 UserDetails 타입을 세션으로 만듦
    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {

        User userEntity = userRepository.findByUsername(username);

        if (userEntity == null) {
            return null;
        } else {
            logger.info("userEntity: " + userEntity);
            return new PrincipalDetails(userEntity);
        }
    }
}
