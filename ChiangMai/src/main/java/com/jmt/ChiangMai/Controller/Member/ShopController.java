package com.jmt.ChiangMai.controller.member;

import com.jmt.ChiangMai.domain.Filter;
import com.jmt.ChiangMai.domain.Shop;
import com.jmt.ChiangMai.dto.FilterDto;
import com.jmt.ChiangMai.service.FilterService;
import com.jmt.ChiangMai.service.ShopService;
import com.jmt.ChiangMai.util.FileUploadUtil;
import com.sun.org.apache.xpath.internal.operations.Mod;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashSet;
import java.util.List;

@Controller
@RequestMapping("/shops")
@RequiredArgsConstructor
public class ShopController {
    private final ShopService shopService;
    private final FileUploadUtil fileUploadUtil;
    private final FilterService filterService;

    @GetMapping
    public String getList(@RequestParam(value = "orderType", defaultValue = "rating") String orderType,
                          @RequestParam(value = "filters", required = false) List<String> filters,
                          @RequestParam(value = "types", required = false) List<String> types,
                          Model model) {
        List<Shop> shops;
        Sort sort = new Sort(Sort.Direction.DESC, orderType);

        if (filters == null && types == null)
            shops = shopService.getAll(sort);
        else
            shops = shopService.getShopsByFilters(types, filters, sort);

        // 체크박스 checked를 위해서 다시 types를 넘겨주는데 3항연산자 사용하는게 좋을까?
        model.addAttribute("types", types == null ? new ArrayList<>() : types);

        model.addAttribute("shops", shops);

        // 최초의 검색만 직접 DB로 조회하고 그 후로는 파라미터로 전달하는 것은 어떨까?
        model.addAttribute("filters", filterService.getFiltersDto(filters));

        return "/members/shops/list";
    }

    // 글쓰기는 회원만 가능하게 시큐리티에 설정 하려고 /edit 추가
    @GetMapping("/edit")
    public String add() {
        return "/members/shops/edit";
    }

    @PostMapping("/edit")
    public String add(@ModelAttribute Shop shop,
                      @RequestParam("images") MultipartFile[] images,
                      @RequestParam("memberId") Long memberId) {
        shop.setShopImages(new HashSet<>());
        //TODO thumbnail 파일 저장?

        if (!images[0].isEmpty()) {
            for (MultipartFile image : images)
                shop.getShopImages().add(fileUploadUtil.uploadFile(image));
        }
        shopService.add(shop, memberId);

        return "redirect:/shops";
    }

}
