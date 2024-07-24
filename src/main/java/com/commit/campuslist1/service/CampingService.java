package com.commit.campuslist1.service;

import com.commit.campuslist1.dto.CampingDTO;

public interface CampingService {
    // 오프셋 기반 페이지네이션을 사용하여 캠핑 정보를 가져오는 메서드
    CampingDTO getCampings(String doName, String sigunguName, int page, int size, String sort, String order);
}
