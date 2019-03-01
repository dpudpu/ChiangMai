package com.jmt.ChiangMai.service;

import com.jmt.ChiangMai.domain.Review;
import com.jmt.ChiangMai.domain.Shop;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

public interface ReviewService {

    Page<Review> getAll(Shop shop, Pageable pageable);

    Review add(Review review, Long shopId, Long memberId);

    Review modify(Review review);

    void delete(Review review);

}
