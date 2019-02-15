package com.jmt.ChiangMai.repository;

import com.jmt.ChiangMai.domain.Filter;
import com.jmt.ChiangMai.domain.Review;
import com.jmt.ChiangMai.domain.Shop;
import com.jmt.ChiangMai.domain.ShopImage;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.transaction.annotation.Transactional;
import java.util.ArrayList;
import java.util.List;

@RunWith(SpringRunner.class)
@DataJpaTest
@Transactional
public class ShopRepositoryTest {

    @Autowired
    ShopRepository shopRepository;
//
//    @Test
//    public void 타입_검색() {
//        List<String> types = new ArrayList<>();
//        types.add("마사지");
//        types.add("식당");
//        Pageable pageable = PageRequest.of(0,2000, Sort.Direction.DESC, "id");
//        List<Shop> shops = shopRepository.findByType(types, pageable);
//
//
//        for (Shop s : shops
//        ) {
//            System.out.println(s.getName());
//        }
//    }

//    @Test
//    public void 영업중_검색() {
//        List<Shop> shops = shopRepository.findByOpenAfterAndCloseBefore(15L);
//        for (Shop s : shops)
//            System.out.println(s.getName());
//    }
//
//    @Test
//    public void 필터_검색() {
//        List<String> types = new ArrayList<>();
//        types.add("식당");
//
//        List<String> filters = new ArrayList<>();
//        filters.add("한식");
//        filters.add("일식");
//
//        Pageable pageable = PageRequest.of(0,2000, Sort.Direction.DESC, "id");
//
//                List < Shop > shops = shopRepository.findByTypeAndFilters(types, filters, pageable);
//        for (Shop s : shops) {
//            System.out.println(s.getId() + "/" + s.getName() + " / " + s.getType() + " / ");
//            for (Filter f : s.getFilters())
//                System.out.println(f.getName());
//        }
//    }

    @Test
    public void 전체검색(){
        Pageable pageable = PageRequest.of(0,2000,Sort.Direction.DESC,"id");
        Page<Shop>  shops = shopRepository.findAll(pageable);
        int i=0;
        for(Shop s : shops){
            i++;
            System.out.println(i+": "+s.getName()+"  / ");
            for(Review si : s.getReviews())
                System.out.println(si.getContent());
        }
    }
}
