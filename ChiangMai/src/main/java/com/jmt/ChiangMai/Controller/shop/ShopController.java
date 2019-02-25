package com.jmt.ChiangMai.controller.shop;

import com.jmt.ChiangMai.domain.Shop;
import com.jmt.ChiangMai.dto.ShopDetailDto;
import com.jmt.ChiangMai.dto.ShopDto;
import com.jmt.ChiangMai.security.MemberDetails;
import com.jmt.ChiangMai.service.TagService;
import com.jmt.ChiangMai.service.ShopService;
import com.jmt.ChiangMai.util.FileUploadUtil;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;

@Controller
@RequestMapping("/shops")
@RequiredArgsConstructor
public class ShopController {
    private final ShopService shopService;
    private final FileUploadUtil fileUploadUtil;
    private final TagService tagService;

    @GetMapping
    public String getList(@RequestParam(value = "orderType", defaultValue = "rating") String orderType,
                          @RequestParam(value = "tags", required = false) List<String> tags,
                          @RequestParam(value = "types", required = false) List<String> types,
                          @RequestParam(value = "map_toggle", defaultValue = "true") Boolean mapToggle,
                          Model model) {
        Page<ShopDto> shops;
        Pageable pageable;
        String viewName;

        if (mapToggle) {
            pageable = Pageable.unpaged();
            viewName = "/shops/map";
        } else {
            // TODO 스크롤 검색 구현할 때 page, size 수정하기
            pageable = PageRequest.of(0, 2000, Sort.Direction.DESC, orderType);
            viewName = "/shops/list";
        }

        shops = shopService.getShops(types, tags, pageable);

        model.addAttribute("types", types == null ? new ArrayList<>() : types);
        model.addAttribute("shops", shops);
        model.addAttribute("map_toggle", mapToggle);
        model.addAttribute("tags", tagService.getTagsDto(tags));

        return viewName;
    }

    @GetMapping("/{shopId}")
    @ResponseBody
    public ShopDetailDto getDetail(@PathVariable Long shopId) {
        ShopDetailDto shop = shopService.getOne(shopId);
        return shop;
    }

    @GetMapping("/edit")
    public String add(Model model) {
        model.addAttribute("tags", tagService.getTags());
        return "/shops/edit";
    }

    @PostMapping("/edit")
    public String add(@ModelAttribute Shop shop,
                      @RequestParam("images") MultipartFile[] images,
                      @RequestParam(value = "tagNames", required = false) List<String> tags) {

        /*
        관리자가 글을 썼으면 status에 true를 입력해서 목록에 바로 출력이 되지만
        유저가 글을 쓰면 status에 false를 입력해 관리자가 수락할때까지 대기시킨다.
         */
        MemberDetails principal = (MemberDetails) SecurityContextHolder.getContext().getAuthentication().getPrincipal();
        Long memberId = principal.getId();

        if (principal.getAuthorities().contains(new SimpleGrantedAuthority("ROLE_ADMIN")))
            shop.setStatus(true);
        else
            shop.setStatus(false);

        shop.setShopImages(new HashSet<>());
        if (!images[0].isEmpty()) {
            for (MultipartFile image : images)
                shop.getShopImages().add(fileUploadUtil.uploadShopImage(image));
        }
        shopService.add(shop, memberId, tags);

        return "redirect:/shops";
    }

    @PutMapping("/edit/{shopId}")
    public String modify(@ModelAttribute Shop shop,
                         @RequestParam("images") MultipartFile[] images,
                         @RequestParam("memberId") Long memberId) {
        shop.setShopImages(new HashSet<>());

        if (!images[0].isEmpty()) {
            for (MultipartFile image : images)
                shop.getShopImages().add(fileUploadUtil.uploadShopImage(image));
        }

        return "redirect:/shops";
    }

}
