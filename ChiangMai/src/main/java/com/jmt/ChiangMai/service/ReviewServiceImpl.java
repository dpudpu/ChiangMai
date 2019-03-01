package com.jmt.ChiangMai.service;

import com.jmt.ChiangMai.domain.Review;
import com.jmt.ChiangMai.domain.Shop;
import com.jmt.ChiangMai.repository.MemberRepository;
import com.jmt.ChiangMai.repository.ReviewRepository;
import com.jmt.ChiangMai.repository.ShopRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.BeanUtils;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class ReviewServiceImpl implements ReviewService {
    private final ReviewRepository reviewRepository;
    private final MemberRepository memberRepository;
    private final ShopRepository shopRepository;

    @Override
    public Page<Review> getAll(Shop shop, Pageable pageable) {

        return null;
//        return reviewRepository.findByShop(shop, pageable);
    }

    @Override
    public Review add(Review review, Long shopId, Long memberId) {

        review.setMember(memberRepository.getMemberById(memberId));
        review.setShop(shopRepository.getShopById(shopId));

        Review reviewInfo = reviewRepository.save(review);
        reviewInfo.setReviewImages(review.getReviewImages());
        return reviewInfo;
    }

    @Override
    public Review modify(Review review) {
        Review reviewInfo = reviewRepository.getOne(review.getId());
        BeanUtils.copyProperties(review, reviewInfo);
        return reviewInfo;
    }

    @Override
    public void delete(Review review) {
        reviewRepository.delete(review);
    }
}
