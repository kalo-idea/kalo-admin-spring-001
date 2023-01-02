package kalo.kaloAdmin_kalo.domain.dto;

import java.time.LocalDateTime;

import com.querydsl.core.annotations.QueryProjection;

import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
public class ReadUsersDto {
    private String kakaoUID;
    private String kaloUID;
    private String username;
    private String email;
    private String phone;
    private String nickname;
    private LocalDateTime birth;
    private String gender;
    private String address;
    private Long point;


    @Builder
    @QueryProjection
    public ReadUsersDto(String kakaoUID, String kaloUID, String username, String email, String phone, String nickname, LocalDateTime birth, String gender, String address, Long point) {
        this.kakaoUID = kakaoUID;
        this.kaloUID = kaloUID;
        this.username = username;
        this.email = email;
        this.phone = phone;
        this.nickname = nickname;
        this.birth = birth;
        this.gender = gender;
        this.address = address;
        this.point = point;
    }

}
