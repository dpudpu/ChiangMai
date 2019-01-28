package com.jmt.ChiangMai.service;

import com.jmt.ChiangMai.domain.Filter;
import com.jmt.ChiangMai.domain.Shop;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;

import java.util.List;

public interface ShopService {
    List<Shop> getAll(Sort sort);

    List<Shop> getShopsByFilters(List<String> types, List<Filter> filters, Pageable pageable);

    void delete(Long id);

    void deleteShopImage(Long id);

    Shop modify(Shop shop);

    Shop add(Shop shop);
 }
