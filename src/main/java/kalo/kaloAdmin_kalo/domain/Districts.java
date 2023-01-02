package kalo.kaloAdmin_kalo.domain;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

import lombok.Getter;

@Entity
@Getter
@Table(name = "districts")
public class Districts extends BaseEntity {

    @Id
    int id;
    
    @Column(length = 8)
    String sido;
    
    @Column(length = 8)
    String sigugun;
    
    @Column(length = 32)
    String name;
}
