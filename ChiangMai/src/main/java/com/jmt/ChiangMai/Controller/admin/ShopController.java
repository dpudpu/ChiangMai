package com.jmt.ChiangMai.controller.admin;

import com.jmt.ChiangMai.domain.Shop;
import com.jmt.ChiangMai.domain.ShopImage;
import com.jmt.ChiangMai.service.ShopService;
import com.jmt.ChiangMai.util.FileUploadUtil;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import java.util.HashSet;

@Controller
@RequestMapping("/admin/shops")
@RequiredArgsConstructor
public class ShopController {
    private final ShopService shopService;
    private final FileUploadUtil fileUploadUtil;


    @GetMapping
    public String add() {
        return "/shops/write";
    }

    @PostMapping
    public String add(@ModelAttribute Shop shop, @RequestParam("images") MultipartFile[] images) {
        shop.setShopImages(new HashSet<ShopImage>());

        if (!images[0].isEmpty()) {
            for (MultipartFile image : images)
                shop.getShopImages().add(fileUploadUtil.uploadFile(image));
        }
        //TODO 글쓴이 넣기
        shop = shopService.add(shop);

        return "redirect:/";
    }
}
