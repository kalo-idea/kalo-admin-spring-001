package kalo.kaloAdmin_kalo.domain;

import java.time.LocalDateTime;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;

import lombok.Getter;

@Entity
@Getter
public class Auths extends BaseEntity {
    
    @Id
    @Column(length = 36, columnDefinition ="char(36)")
    String id;

    @Column(length = 32)
    String type;
    
    @Column(length = 32)
    String kakao;
    
    @Column(length = 32)
    String email;

    @Column(length = 32)
    String name;

    LocalDateTime birth;

    @Column(length = 8)
    String gender;

    String tel;

    String address;

    @Column(length = 16)
    String sido;

    @Column(length = 16)
    String sigugun;

    Boolean promotionCheck;

    String fcmToken;

    LocalDateTime recentLogin;
}