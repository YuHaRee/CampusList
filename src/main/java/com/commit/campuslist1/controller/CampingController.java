package com.commit.campuslist1.controller;

import com.commit.campuslist1.dto.CampingDTO;
import com.commit.campuslist1.service.CampingService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class CampingController {
    @Autowired
    private CampingService campingService;

    // API 요청을 받아 서비스 메서드를 호출하고 결과를 반환
    @GetMapping("/v1/campings")
    public CampingDTO getCampings(
            @RequestParam String doName,
            @RequestParam(required = false) String sigunguName,
            @RequestParam(defaultValue = "0") int page,
            @RequestParam(defaultValue = "10") int size,
            @RequestParam(defaultValue = "createdDate") String sort,
            @RequestParam(defaultValue = "desc") String order) {
        return campingService.getCampings(doName, sigunguName, page, size, sort, order);
    }
}
