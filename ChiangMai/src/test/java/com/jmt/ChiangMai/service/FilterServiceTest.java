//package com.jmt.ChiangMai.service;
//
//import com.jmt.ChiangMai.domain.Filter;
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
//    FilterService filterService;;
//
//    @Test
//    public void 조회(){
//        Sort sort = new Sort(Sort.Direction.DESC, "type");
//        List<Filter> filters = filterService.getFilters(null,sort);
//
//        for (Filter f: filters
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
//        List<Filter> filters = filterService.getFilters(list,sort);
//
//        for (Filter f: filters
//        ) {
//            System.out.println(f.getName()+"/"+f.getType());
//        }
//    }
//}
