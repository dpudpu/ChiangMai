//package com.jmt.ChiangMai.service;
//
//import com.jmt.ChiangMai.domain.Tag;
//import org.junit.Test;
//import org.junit.runner.RunWith;
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.boot.test.context.SpringBootTest;
//import org.springframework.data.domain.Sort;
//import org.springframework.test.context.junit4.SpringRunner;
//import org.springframework.transaction.annotation.Transactional;
//
//import java.util.ArrayList;
//import java.util.List;
//
//@RunWith(SpringRunner.class)
//@SpringBootTest
//@Transactional
//public class FilterServiceTest {
//
//    @Autowired
//    TagService filterService;;
//
//    @Test
//    public void 조회(){
//        Sort sort = new Sort(Sort.Direction.DESC, "type");
//        List<Tag> tags = filterService.getTags(null,sort);
//
//        for (Tag f: tags
//             ) {
//            System.out.println(f.getName()+"/"+f.getType());
//        }
//    }
//
//    @Test
//    public void type조회(){
//        Sort sort = new Sort(Sort.Direction.DESC, "type");
//        List<String> list = new ArrayList<>();
//        list.add("마사지");
//        List<Tag> tags = filterService.getTags(list,sort);
//
//        for (Tag f: tags
//        ) {
//            System.out.println(f.getName()+"/"+f.getType());
//        }
//    }
//}
