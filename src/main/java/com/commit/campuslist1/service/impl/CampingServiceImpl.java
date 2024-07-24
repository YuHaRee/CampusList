package com.commit.campuslist1.service.impl;

import com.commit.campuslist1.dto.CampingDTO;
import com.commit.campuslist1.entity.Camping;
import com.commit.campuslist1.repository.CampingRepository;
import com.commit.campuslist1.service.CampingService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class CampingServiceImpl implements CampingService {

    @Autowired
    private CampingRepository campingRepository;

    @Override
    public CampingDTO getCampings(String doName, String sigunguName, int page, int size, String sort, String order) {
        // 오프셋 계산
        int offset = page * size;

        // 캠핑 목록을 가져오는 쿼리 호출
        List<Camping> campings = campingRepository.findCampings(doName, sigunguName, sort, order, offset, size);

        // 캠핑장의 총 개수를 구하는 쿼리 호출
        long total = campingRepository.countCampings(doName, sigunguName);

        // 캠핑 목록을 DTO로 변환
        List<CampingDTO> campingDtos = campings.stream().map(camping -> {
            CampingDTO dto = new CampingDTO();
            dto.setCampId(camping.getCampId());
            dto.setCampName(camping.getCampName());
            dto.setLineIntro(camping.getLineIntro());
            dto.setIntro(camping.getIntro());
            dto.setDoName(camping.getDoName());
            dto.setSigunguName(camping.getSigunguName());
            dto.setPostCode(camping.getPostCode());
            dto.setFeatureSummary(camping.getFeatureSummary());
            dto.setInduty(camping.getInduty());
            dto.setAddr(camping.getAddr());
            dto.setAddrDetails(camping.getAddrDetails());
            dto.setMapX(camping.getMapX());
            dto.setMapY(camping.getMapY());
            dto.setTel(camping.getTel());
            dto.setHomepage(camping.getHomepage());
            dto.setStaffCnt(camping.getStaffCnt());
            dto.setGeneralSiteCnt(camping.getGeneralSiteCnt());
            dto.setCarSiteCnt(camping.getCarSiteCnt());
            dto.setGlampingSiteCnt(camping.getGlampingSiteCnt());
            dto.setCaravanSiteCnt(camping.getCaravanSiteCnt());
            dto.setPersonalCaravanSiteCnt(camping.getPersonalCaravanSiteCnt());
            dto.setContentId(camping.getContentId());
            return dto;
        }).collect(Collectors.toList());

        // 응답 DTO 생성 및 반환
        CampingDTO responseDto = new CampingDTO();
        responseDto.setCampings(campingDtos);
        responseDto.setTotal(total);

        return responseDto;
    }
}
