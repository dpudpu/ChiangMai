package com.jmt.ChiangMai.controller.admin;

import com.jmt.ChiangMai.domain.Shop;
import com.jmt.ChiangMai.domain.ShopImages;
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
    public String addShop() {
        return "/admin/shops/write";
    }

    @PostMapping
    public String addShop(@ModelAttribute Shop shop, @RequestParam("files") MultipartFile[] files) {
        shop.setShopImages(new HashSet<ShopImages>());

        if (!files[0].isEmpty()) {
            for (MultipartFile file : files)
                shop.getShopImages().add(fileUploadUtil.uploadFile(file));
        }
        Shop shopInnfo = shopService.addShop(shop);

        return "redirect:/";
    }
}
