package kalo.kaloAdmin_kalo.domain;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

@Entity
@Table(name = "reports")
public class Reports extends BaseEntity {
    
    @Id
    @Column(length = 36, columnDefinition ="char(36)")
    String id;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "UserId")
    Users users; // 신고자

    String reportTargetId; // 신고 대상 id
    Integer type; // 게시글인지 댓글인지
    Integer reportType; // 신고 종류
    Integer resolutionStatus; // 해결 상태 전 중 완료
    String progress; // 관리자끼리 공유하는 현재 진행 상황

    @Column(columnDefinition = "TEXT")
    String content; // 신고 내용
    
    String url; // 신고 근거 URL

    Boolean deleted; // 삭제 여부
}
