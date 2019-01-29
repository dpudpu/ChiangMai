package com.jmt.ChiangMai.controller.member;

import com.jmt.ChiangMai.domain.Shop;
import com.jmt.ChiangMai.service.ShopService;
import com.jmt.ChiangMai.util.FileUploadUtil;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import java.util.HashSet;
import java.util.List;

@Controller
@RequestMapping("/shops")
@RequiredArgsConstructor
public class ShopController {
    private final ShopService shopService;
    private final FileUploadUtil fileUploadUtil;

    @GetMapping
    public String getList(@RequestParam("orderType") String orderType,
                          @RequestParam("filters") List<String> filters,
                          @RequestParam("types") List<String> types) {
        List<Shop> shops;
        Sort sort = new Sort(Sort.Direction.DESC, orderType);
//        shops = shopService.getAll();

        shops = shopService.getShopsByFilters(types, filters, sort);
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
        //TODO 글쓴이 넣기
        shopService.add(shop, memberId);

        return "redirect:/shops";
    }

}
