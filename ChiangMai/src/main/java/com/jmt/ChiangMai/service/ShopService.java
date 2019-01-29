package com.jmt.ChiangMai.service;

import com.jmt.ChiangMai.domain.Shop;
import org.springframework.data.domain.Sort;

import java.util.List;

public interface ShopService {
    List<Shop> getAll(Sort sort);

    List<Shop> getShopsByFilters(List<String> types, List<String> filters, Sort sort);

    void delete(Long id);

    Shop modify(Shop shop);

    Shop add(Shop shop, Long memberId);
}
