package com.jmt.ChiangMai.service;

import com.jmt.ChiangMai.domain.Shop;
import com.jmt.ChiangMai.dto.ShopDetailDto;
import com.jmt.ChiangMai.dto.ShopDto;
import com.jmt.ChiangMai.repository.TagRepository;
import com.jmt.ChiangMai.repository.MemberRepository;
import com.jmt.ChiangMai.repository.ReviewRepository;
import com.jmt.ChiangMai.repository.ShopRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.BeanUtils;
import org.springframework.data.domain.*;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.ArrayList;
import java.util.List;

@Service
@RequiredArgsConstructor
public class ShopServiceImpl implements ShopService {
    private final ShopRepository shopRepository;
    private final MemberRepository memberRepository;
    private final TagRepository tagRepository;



    @Override
    @Transactional(readOnly = true)
    public Page<ShopDto> getShops(List<String> types, List<String> filters, Pageable pageable) {
        Page<Shop> shops;
        List<ShopDto> shopDtos = new ArrayList<>();
        // 조회를 그냥 네개로 나누지말고 두가지로 하는건 어떨까? (type, tags 전용 조회 없앤다.)
        if (filters == null && types == null)
            shops = shopRepository.findAll(pageable);
        else if (filters == null)
            shops = shopRepository.findByTypes(types, pageable);
        else if (types == null)
            shops = shopRepository.findByTags(filters, pageable);
        else
            shops = shopRepository.findByTypesAndTags(types, filters, pageable);

        for (Shop origin : shops) {
            ShopDto target = new ShopDto();
            BeanUtils.copyProperties(origin, target);
            if (pageable != null && origin.getShopImages().iterator().hasNext()) {
                target.setShopImage(origin.getShopImages().iterator().next());
            }
            shopDtos.add(target);
        }

        //TODO 게시판일 때 이미지 넣어주기
        return new PageImpl<ShopDto>(shopDtos,pageable, shops.getTotalElements());
    }

    @Override
    @Transactional(readOnly = true)
    public ShopDetailDto getOne(Long id){
        Shop shop = shopRepository.getShopById(id);
        ShopDetailDto shopDetailDto = new ShopDetailDto();
        BeanUtils.copyProperties(shop, shopDetailDto);
        if(shop.getShopImages().iterator().hasNext())
            shopDetailDto.setShopImage(shop.getShopImages().iterator().next());

        return shopDetailDto;
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
    public Shop add(Shop shop, Long memberId, List<String> filters) {
        shop.setTags(tagRepository.findByName(filters));
        shop.setMember(memberRepository.getMemberById(memberId));
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
