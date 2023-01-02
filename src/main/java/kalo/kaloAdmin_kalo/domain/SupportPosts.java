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
@Table(name = "supportPosts")
public class SupportPosts extends BaseEntity {
    
    @Id
    @Column(length = 36, columnDefinition ="char(36)")
    String id;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name="UserId")
    Users users;
    
    String nickname;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name="PostId")
    Posts posts;

}
