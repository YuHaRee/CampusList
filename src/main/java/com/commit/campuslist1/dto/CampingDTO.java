package com.commit.campuslist1.dto;

import lombok.Data;

import java.util.List;

@Data
public class CampingDTO {
    private Long campId;
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

    // 응답용 필드
    private List<CampingDTO> campings;  // 캠핑 목록
    private long total;                 // 캠핑장의 총 개수
}
