package kalo.kaloAdmin_kalo.domain;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import lombok.Getter;

@Entity
@Getter
@Table(name = "users")
public class Users extends BaseEntity {
    
    @Id
    @Column(length = 36, columnDefinition ="char(36)")
    String id;

    @Column(length = 32)
    String type;
    @Column(length = 32)
    String nickname;

    String intro;
    String profileSrc;
    String publicInfos;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name="AuthId")
    Auths auths;
}
