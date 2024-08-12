package com.commit.campuslist1.entity;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

import java.time.LocalDateTime;

@Entity
@Table(name = "camping")
@Getter
@Setter
@ToString
public class Camping {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "campId")
    private Long campId; // PK 키

    private String campName;
    private String lineIntro;
    private String intro;
    private String doName;
    private String sigunguName;
    private String postCode;
    private String featureSummary;
    private String induty;
    private String addr;
    private String addrDetails;
    private Double mapX;
    private Double mapY;
    private String tel;
    private String homepage;
    private Integer staffCnt;
    private Integer generalSiteCnt;
    private Integer carSiteCnt;
    private Integer glampingSiteCnt;
    private Integer caravanSiteCnt;
    private Integer personalCaravanSiteCnt;
    private Long contentId;

    @Column(name = "created_date", updatable = false)
    private LocalDateTime createdDate;

    @Column(name = "modified_date")
    private LocalDateTime modifiedDate;

    @PrePersist
    protected void onCreate() {
        createdDate = LocalDateTime.now();
    }

    @PreUpdate
    protected void onUpdate() {
        modifiedDate = LocalDateTime.now();
    }
}
