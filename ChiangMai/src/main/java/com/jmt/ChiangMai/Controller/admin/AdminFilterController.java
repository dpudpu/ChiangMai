package com.jmt.ChiangMai.controller.admin;

import com.jmt.ChiangMai.domain.Filter;
import com.jmt.ChiangMai.service.FilterService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/filters")
@RequiredArgsConstructor
public class AdminFilterController {
    private final FilterService filterService;

    @PutMapping("{filterId}")
    public String modify(@PathVariable Filter filter){
        //TODO 수정 구현
        return null;
    }

    @DeleteMapping("{filterId}")
    public String delete(@PathVariable Long id){
        filterService.delete(id);
        return null;
    }
}
