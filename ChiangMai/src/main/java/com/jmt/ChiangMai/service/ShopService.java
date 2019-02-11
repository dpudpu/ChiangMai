package com.jmt.ChiangMai.service;

import com.jmt.ChiangMai.domain.Shop;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import java.util.List;

public interface ShopService {

    Page<Shop> getShops(List<String> types, List<String> filters, Pageable pageable);

    void delete(Long id);

    Shop modify(Shop shop);

    Shop add(Shop shop, Long memberId);
}
