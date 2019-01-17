package com.jmt.ChiangMai.repository;

import com.jmt.ChiangMai.domain.Member;
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

@RunWith(SpringRunner.class)
@DataJpaTest
@Transactional
public class MemberRepositoryTest {

    @Autowired
    private MemberRepository memberRepository;

    @Test
    public void 이메일_패스워드_조회(){
        Member member = memberRepository.findByEmailAndPassword("dpudpu11@gmail.com","1234");
        System.out.println("--------------------");
        System.out.println(member.getNickname());
        member.setNickname("asd");
        System.out.println("==================o");
        System.out.println(member.getNickname());
    }

    @Test
    public void 닉네임조회(){
        boolean check = memberRepository.existsMemberByNickname("배대준");
        System.out.println(check);
    }

    @Test
    public void 전체조회(){
        PageRequest pageRequest = PageRequest.of(0, 3, Sort.Direction.DESC,"id");
        Page<Member> members =  memberRepository.findAll(pageRequest);

        for(Member m : members)
            System.out.println(m.getNickname()+" / "+m.getEmail());

        System.out.println(members.getTotalPages());
        System.out.println(members.hasNext());
        System.out.println(members.getTotalElements());

    }

}
