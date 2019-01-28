package com.jmt.ChiangMai.service;

import com.jmt.ChiangMai.domain.Review;
import com.jmt.ChiangMai.domain.Shop;
import com.jmt.ChiangMai.repository.ReviewRepository;
import com.jmt.ChiangMai.repository.ShopRepository;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.transaction.annotation.Transactional;

@RunWith(SpringRunner.class)
@SpringBootTest
@Transactional
public class ReviewServiceTest {

    @Autowired
    private ReviewService reviewService;
    @Autowired
    private ReviewRepository reviewRepository;
    @Autowired
    private ShopRepository shopRepository;

    @Test
    public void shopId조회() {
        Pageable pageable = PageRequest.of(0, 3, Sort.Direction.DESC, "regdate");
        Shop shop = shopRepository.getOne(1L);
        System.out.println(shop.getName());

        System.out.println("-------------------------");
        Page<Review> reviews = reviewService.getAll(shop, pageable);
        System.out.println("-----------------");
        for (Review r : reviews)
            System.out.println(r.getId() + "/ " + r.getRating() + "/");
    }

    @Test
    public void 수정() {
        Review review = reviewRepository.getOne(1L);
        reviewService.add(review);
        System.out.println(review.getRating());
        review.setRating(15);
        Review review2 = reviewService.modify(review);
        System.out.println(review2.getRating());
        this.shopId조회();
    }
}
