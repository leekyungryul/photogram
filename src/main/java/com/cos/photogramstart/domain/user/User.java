package com.cos.photogramstart.domain.user;

import java.time.LocalDateTime;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.PrePersist;
import javax.persistence.Table;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Builder
@NoArgsConstructor
@AllArgsConstructor
@Data
@Entity // DB에 테이블을 생성
@Table(name = "user") // user 테이블을 만들어줌
public class User {

    @Id // Primary Key
    @GeneratedValue(strategy = GenerationType.IDENTITY) // 번호 증가 전략이 데이터베이스를 따라감
    private int id;
    @Column(length = 20, unique = true)
    private String username;
    @Column(nullable = false)
    private String password;
    @Column(nullable = false)
    private String email;
    @Column(nullable = false)
    private String name;
    private String website; // 웹사이트
    private String bio; // 자기소개
    private String phone;
    private String gender;
    private String profileImageUrl;
    private String role; // USER, ADMIN
    private LocalDateTime createDate;

    @PrePersist // DB에 INSERT 되기 직전에 실행
    public void createDate() {
        this.createDate = LocalDateTime.now();
    }
}
