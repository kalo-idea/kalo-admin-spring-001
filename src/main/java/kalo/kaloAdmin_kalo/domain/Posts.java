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
@Table(name = "posts")
public class Posts extends BaseEntity {
    
    @Id
    @Column(length = 36, columnDefinition ="char(36)")
    String id;

    @Column(length = 32)
    String type;
    String title;

    @Column(columnDefinition = "TEXT")
    String content;

    String hashtags;

    String photos;

    Long supportCount;

    Long viewCount;

    @Column(length = 32)
    String purpose;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name="UserId")
    Users users;

    Long goal;

    Long replyCount;

    String category;

    @Column(length = 16)
    String sido;

    @Column(length = 16)
    String sigugun;

    Long likeCount;

    Long dislikeCount;

    String status;

    String topic;

}
