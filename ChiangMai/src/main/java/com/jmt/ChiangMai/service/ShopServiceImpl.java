package com.jmt.ChiangMai.service;

import com.jmt.ChiangMai.domain.Shop;
import com.jmt.ChiangMai.repository.MemberRepository;
import com.jmt.ChiangMai.repository.ShopRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.BeanUtils;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
@RequiredArgsConstructor
public class ShopServiceImpl implements ShopService {
    private final ShopRepository shopRepository;
    private final MemberRepository memberRepository;

    @Override
    @Transactional(readOnly = true)
    public List<Shop> getAll(Sort sort) {
        return shopRepository.findAll();
    }

    @Override
    @Transactional(readOnly = true)
    public List<Shop> getShopsByFilters(List<String> types, List<String> filters, Sort sort) {
        List<Shop> shops;
        if (filters == null)
            shops= shopRepository.findByTypes(types, sort);
        else if (types == null)
            shops = shopRepository.findByFilters(filters, sort);
        else
            shops = shopRepository.findByTypesAndFilters(types, filters, sort);
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
