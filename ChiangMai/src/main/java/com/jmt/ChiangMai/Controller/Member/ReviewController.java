package com.jmt.ChiangMai.controller.member;


import com.jmt.ChiangMai.domain.Review;
import com.jmt.ChiangMai.service.ReviewService;
import com.jmt.ChiangMai.util.FileUploadUtil;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import java.util.HashSet;

@Controller
@RequestMapping("/reviews")
@RequiredArgsConstructor
public class ReviewController {
    private final ReviewService reviewService;
    private final FileUploadUtil fileUploadUtil;

    @GetMapping
    public String add(){
        return "members/review/edit";
    }

    @PostMapping
    public String add(@ModelAttribute Review review, @RequestParam("images")MultipartFile[] images){
        //TODO 글쓴이, shop_id 추가하기
        review.setShopImages(new HashSet<>());

        if (!images[0].isEmpty()) {
            for (MultipartFile image : images)
                review.getShopImages().add(fileUploadUtil.uploadFile(image));
        }

        review = reviewService.add(review);

        return "redirect:/";
    }
}
