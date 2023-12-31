package com.cos.photogramstart.web.api;

import javax.validation.Valid;

import org.slf4j.Logger;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RestController;

import com.cos.photogramstart.config.auth.PrincipalDetails;
import com.cos.photogramstart.domain.user.User;
import com.cos.photogramstart.service.UserService;
import com.cos.photogramstart.web.dto.CMRespDto;
import com.cos.photogramstart.web.dto.user.UserUpdateDto;

import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor
@RestController
public class UserApiController {

    Logger logger = org.slf4j.LoggerFactory.getLogger(UserApiController.class);

    private final UserService userService;

    @PutMapping("/api/user/{id}")
    public CMRespDto<?> update(@PathVariable int id
            , @Valid UserUpdateDto userUpdateDto
            , BindingResult bindingResult // 꼭 @Valid가 적혀있는 다음 파라미터에 적어야 함
            , @AuthenticationPrincipal PrincipalDetails principalDetails) {

        logger.info("userUpdateDto: {}", userUpdateDto);

        User userEntity = userService.update(id, userUpdateDto.toEntity());

        principalDetails.setUser(userEntity); // 세션 정보 변경

        return new CMRespDto<>(1, "회원수정완료", userEntity);

    }

}
