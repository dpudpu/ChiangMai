package com.jmt.ChiangMai.service;

import com.jmt.ChiangMai.domain.Shop;
import com.jmt.ChiangMai.repository.MemberRepository;
import com.jmt.ChiangMai.repository.ShopRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.BeanUtils;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
@RequiredArgsConstructor
public class ShopServiceImpl implements ShopService {
    private final ShopRepository shopRepository;
    private final MemberRepository memberRepository;


    @Transactional(readOnly = true)
    public Page<Shop> getShops(List<String> types, List<String> filters, Pageable pageable) {
        Page<Shop> shops;
        if (filters == null && types == null)
            shops = shopRepository.findAll(pageable);
        else if (filters == null)
            shops = shopRepository.findByTypes(types, pageable);
        else if (types == null)
            shops = shopRepository.findByFilters(filters, pageable);
        else
            shops = shopRepository.findByTypesAndFilters(types, filters, pageable);
        return shops;
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
    public Shop add(Shop shop, Long memberId) {
        shop.setMember(memberRepository.getOne(memberId));
        Shop shopInfo = shopRepository.save(shop);
        shopInfo.setShopImages(shopInfo.getShopImages());
        return shopInfo;
    }


    @Override
    @Transactional
    public void delete(Long id) {
        shopRepository.deleteById(id);
    }

}
