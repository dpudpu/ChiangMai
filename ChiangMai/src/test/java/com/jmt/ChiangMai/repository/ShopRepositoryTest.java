package com.jmt.ChiangMai.repository;

import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.transaction.annotation.Transactional;

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
//        List<String> tags = new ArrayList<>();
//        tags.add("한식");
//        tags.add("일식");
//
//        Pageable pageable = PageRequest.of(0,2000, Sort.Direction.DESC, "id");
//
//                List < Shop > shops = shopRepository.findByTypeAndFilters(types, tags, pageable);
//        for (Shop s : shops) {
//            System.out.println(s.getId() + "/" + s.getName() + " / " + s.getType() + " / ");
//            for (Tag f : s.getTags())
//                System.out.println(f.getName());
//        }
//    }

//    @Test
//    public void 전체검색(){
//        Pageable pageable = PageRequest.of(0,2000,Sort.Direction.DESC,"id");
//        Page<Shop>  shops = shopRepository.findAll(pageable);
//        int i=0;
//        for(Shop s : shops){
//            i++;
//            System.out.println(i+": "+s.getName()+"  / ");
//            for(Review si : s.getReviews())
//                System.out.println(si.getContent());
//        }
//    }
}
