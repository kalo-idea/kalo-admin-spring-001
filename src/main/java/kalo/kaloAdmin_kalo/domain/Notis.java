package kalo.kaloAdmin_kalo.domain;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "notis")
public class Notis extends BaseEntity{
    
    @Id
    @Column(columnDefinition ="char(36)")
    String id;

    String type;
    String title;
    String content;

    Boolean check;
    Boolean display;
    @Column(columnDefinition = "char(36)")
    String senderId;
    @Column(columnDefinition = "char(36)")
    String receiverId;
    String targetId;
}
