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

    /*
    1. ShopController를 3개 만든다.
    @RequestMapping("/admin/shops")
    @RequestMapping("/member/shops")
    @RequestMapping("/shops")


   2. ShopController를 admin용 member용을 만들되
     @GetMapping("/admin/shops/1")
     @GetMapping("/member/shops/1")
     /member 멤버만 접속 가능하지
     @GetMapping("/member/shops")는 시큐리티 설정에서 모두가 접근 가능하게 설정 해준다.

         .antMatchers("/api/foos").authenticated()
    .antMatchers("/api/admin/**").hasRole("ADMIN")
     */

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
