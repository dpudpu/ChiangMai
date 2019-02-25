package com.jmt.ChiangMai.controller.admin;

import com.jmt.ChiangMai.domain.Filter;
import com.jmt.ChiangMai.service.FilterService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Controller
@RequestMapping("/filters")
@RequiredArgsConstructor
public class AdminFilterController {
    private final FilterService filterService;

    @GetMapping
    public String getList(@RequestParam(value = "types", required = false) List<String> types,
                          Model model) {

        List<Filter> filters = filterService.getFilters();

        model.addAttribute("filters", filters);

        return "/admin/filters/list";
    }

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
