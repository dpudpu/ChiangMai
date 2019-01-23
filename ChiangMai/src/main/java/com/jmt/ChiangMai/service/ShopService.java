package com.jmt.ChiangMai.service;

import com.jmt.ChiangMai.domain.Filter;
import com.jmt.ChiangMai.domain.Shop;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;

import java.util.List;

public interface ShopService {
    List<Shop> getShops(Sort sort);

    List<Shop> getShopsByFilters(List<String> types, List<Filter> filters, Pageable pageable);

    void deleteShop(Long id);

    void deleteShopImage(Long id);

    Shop modifyShop(Shop shop);

    Shop addShop(Shop shop);
 }
