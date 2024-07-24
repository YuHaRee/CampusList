package com.commit.campuslist1.view;

import com.commit.campuslist1.service.CampingService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
public class CampingViewController {
    @Autowired
    private CampingService campingService;

    // 뷰 요청을 받아 서비스 메서드를 호출하고 결과를 모델에 추가하여 뷰를 렌더링
    @GetMapping("/campings")
    public String getCampings(
            @RequestParam String doName,
            @RequestParam(required = false) String sigunguName,
            @RequestParam(defaultValue = "0") int page,
            @RequestParam(defaultValue = "10") int size,
            @RequestParam(defaultValue = "createdDate") String sort,
            @RequestParam(defaultValue = "desc") String order,
            Model model) {
        model.addAttribute("campingResponse", campingService.getCampings(doName, sigunguName, page, size, sort, order));
        return "campingList";
    }
}
