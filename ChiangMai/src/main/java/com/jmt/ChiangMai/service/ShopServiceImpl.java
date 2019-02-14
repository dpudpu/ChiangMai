package com.jmt.ChiangMai.service;

import com.jmt.ChiangMai.domain.Shop;
import com.jmt.ChiangMai.dto.ShopDto;
import com.jmt.ChiangMai.repository.MemberRepository;
import com.jmt.ChiangMai.repository.ShopRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.BeanUtils;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageImpl;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
public class ShopServiceImpl implements ShopService {
    private final ShopRepository shopRepository;
    private final MemberRepository memberRepository;


    @Override
    @Transactional(readOnly = true)
    public Page<ShopDto> getShops(List<String> types, List<String> filters, Pageable pageable) {
        Page<Shop> shops;
        List<ShopDto> shopDtos = new ArrayList<>();
        if (filters == null && types == null)
            shops = shopRepository.findAll(pageable);
        else if (filters == null)
            shops = shopRepository.findByTypes(types, pageable);
        else if (types == null)
            shops = shopRepository.findByFilters(filters, pageable);
        else
            shops = shopRepository.findByTypesAndFilters(types, filters, pageable);

        for (Shop origin : shops) {
            ShopDto target = new ShopDto();
            BeanUtils.copyProperties(origin, target);
            if (pageable != null) {// TODO list용 대표 이미지 저장
            }
            shopDtos.add(target);
        }

        //TODO 게시판일 때 이미지 넣어주기
        return new PageImpl<ShopDto>(shopDtos,pageable, shops.getTotalElements());
    }

    @Override
    @Transactional(readOnly = true)
    public Shop getOne(Long id){
        return shopRepository.getShopById(id);
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
