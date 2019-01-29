package com.jmt.ChiangMai.controller.member;

import com.jmt.ChiangMai.domain.Filter;
import com.jmt.ChiangMai.service.FilterService;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.List;

@Controller
@RequestMapping("/filters")
@RequiredArgsConstructor
public class FilterController {
    private final FilterService filterService;

    @GetMapping
    public String getList(@RequestParam(value = "types", required = false) List<String> types,
                          Model model) {

        Sort sort = new Sort(Sort.Direction.DESC, "type");
        List<Filter> filters = filterService.getFilters(null, sort);

        model.addAttribute("filters", filters);

        return "/members/filters/list";
    }
}
