package com.jmt.ChiangMai.controller.shop;


import com.jmt.ChiangMai.domain.Review;
import com.jmt.ChiangMai.security.MemberDetails;
import com.jmt.ChiangMai.service.ReviewService;
import com.jmt.ChiangMai.util.FileUploadUtil;
import lombok.RequiredArgsConstructor;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
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
    public String add(@RequestParam("shopId") Long shopId,
                      Model model) {
        model.addAttribute("shopId", shopId);
        return "/shops/review/edit";
    }

    @PostMapping
    @ResponseBody
    public void add(@ModelAttribute Review review,
                      @RequestParam("images") MultipartFile[] images,
                      @RequestParam("shopId") Long shopId) {
        MemberDetails principal = (MemberDetails) SecurityContextHolder.getContext().getAuthentication().getPrincipal();
        Long memberId = principal.getId();

        review.setReviewImages(new HashSet<>());
        //TODO 파일업로드 에러
        if (!images[0].isEmpty()) {
            for (MultipartFile image : images)
                review.getReviewImages().add(fileUploadUtil.uploadReviewImage(image));
        }
        reviewService.add(review, shopId, memberId);
    }
}
