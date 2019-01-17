package com.jmt.ChiangMai.repository;

import com.jmt.ChiangMai.domain.Member;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;


@Repository
public interface MemberRepository extends JpaRepository<Member, Long> {

    Member findByEmailAndPassword(String email, String password);

    Page<Member> findByEmailContaining(String email, Pageable pageable);

    Page<Member> findByNicknameContaining(String nickname, Pageable pageable);

    boolean existsMemberByEmail(String email);

    boolean existsMemberByNickname(String nickname);

    boolean existsMemberByPassword(String password);

    Member findByPassword(String password);

}
