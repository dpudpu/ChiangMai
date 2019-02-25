package com.jmt.ChiangMai.controller.admin;

import com.jmt.ChiangMai.domain.Shop;
import com.jmt.ChiangMai.service.ShopService;
import com.jmt.ChiangMai.util.FileUploadUtil;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

@Controller
@RequestMapping("/admin/shops")
@RequiredArgsConstructor
public class AdminShopController {
    private final ShopService shopService;
    private final FileUploadUtil fileUploadUtil;

    @GetMapping("{/shopId}")
    public String modifyForm(@PathVariable Long id) {
        return null;
    }

    @PutMapping("{/shopId}")
    public String modify(@PathVariable Shop shop) {
        return null;
    }

    @DeleteMapping("{/shopId}")
    public String modify(@PathVariable Long id){
        return null;
    }
}
