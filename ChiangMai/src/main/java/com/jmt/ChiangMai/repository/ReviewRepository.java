package com.jmt.ChiangMai.repository;

import com.jmt.ChiangMai.domain.Review;
import com.jmt.ChiangMai.domain.Shop;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;


public interface ReviewRepository extends JpaRepository<Review, Long> {

//    Page<Review> findByShop(Shop shop, Pageable pageable);
}
