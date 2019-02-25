package com.jmt.ChiangMai.controller.admin;

import com.jmt.ChiangMai.domain.Tag;
import com.jmt.ChiangMai.service.TagService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Controller
@RequestMapping("/filters")
@RequiredArgsConstructor
public class AdminTagController {
    private final TagService tagService;

    @GetMapping
    public String getList(@RequestParam(value = "types", required = false) List<String> types,
                          Model model) {

        List<Tag> tags = tagService.getTags();

        model.addAttribute("filters", tags);

        return "/admin/tags/list";
    }

    @PutMapping("{filterId}")
    public String modify(@PathVariable Tag tag){
        //TODO 수정 구현
        return null;
    }

    @DeleteMapping("{filterId}")
    public String delete(@PathVariable Long id){
        tagService.delete(id);
        return null;
    }
}
