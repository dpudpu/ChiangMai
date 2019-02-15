package com.jmt.ChiangMai.service;

import com.jmt.ChiangMai.domain.Review;
import com.jmt.ChiangMai.domain.Shop;
import com.jmt.ChiangMai.repository.ReviewRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.BeanUtils;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class ReviewServiceImpl implements ReviewService {
    private final ReviewRepository reviewRepository;

    @Override
    public Page<Review> getAll(Shop shop, Pageable pageable) {

        return reviewRepository.findByShop(shop, pageable);
    }

    @Override
    public Review add(Review review) {
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
