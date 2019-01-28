package com.jmt.ChiangMai.service;

import com.jmt.ChiangMai.domain.Filter;
import com.jmt.ChiangMai.domain.Shop;
import com.jmt.ChiangMai.repository.ShopRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.BeanUtils;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
@RequiredArgsConstructor
public class ShopServiceImpl implements ShopService {
    private final ShopRepository shopRepository;

    @Override
    @Transactional(readOnly = true)
    public List<Shop> getAll(Sort sort) {
        return shopRepository.findAll();
    }

    @Override
    @Transactional(readOnly = true)
    public List<Shop> getShopsByFilters(List<String> types, List<Filter> filters, Pageable pageable) {
        return shopRepository.findByTypeAndFilters(types, filters, pageable);
    }

    @Override
    @Transactional
    public Shop modify(Shop shop) {
        Shop shopInfo = shopRepository.getOne(shop.getId());
        BeanUtils.copyProperties(shop, shopInfo);
        // TODO 이미지 수정
        return shopInfo;
    }

    @Override
    @Transactional
    public Shop add(Shop shop) {
        Shop shopInfo = shopRepository.save(shop);
        shopInfo.setShopImages(shopInfo.getShopImages());
        return shopInfo;
    }


    @Override
    @Transactional
    public void delete(Long id) {
        shopRepository.deleteById(id);
    }

    @Override
    @Transactional
    public void deleteShopImage(Long id) {
    }

}
