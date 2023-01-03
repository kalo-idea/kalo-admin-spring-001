package kalo.kaloAdmin_kalo.domain.dto;

import java.time.LocalDateTime;

import com.querydsl.core.annotations.QueryProjection;

import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
public class SearchResultDto {
    
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

    @QueryProjection
    @Builder
    public SearchResultDto(UsersInfoDto usersInfoDto, CountLedgersDto countLedgersDto) {
        this.kakaoUID = usersInfoDto.getKakaoUID();
        this.kaloUID = usersInfoDto.getKaloUID();
        this.username = usersInfoDto.getUsername();
        this.email = usersInfoDto.getEmail();
        this.phone = usersInfoDto.getPhone();
        this.nickname = usersInfoDto.getNickname();
        this.birth = usersInfoDto.getBirth();
        this.gender = usersInfoDto.getGender();
        this.address = usersInfoDto.getAddress();
        this.point = countLedgersDto.getPoint();
    }
    
}
