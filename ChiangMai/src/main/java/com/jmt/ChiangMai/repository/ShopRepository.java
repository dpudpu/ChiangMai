package com.jmt.ChiangMai.repository;

import com.jmt.ChiangMai.domain.Shop;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;

public interface ShopRepository extends JpaRepository<Shop, Long> {

    @Query(value = "SELECT DISTINCT s FROM Shop s LEFT JOIN FETCH s.shopImages WHERE status = true",
            countQuery = "SELECT COUNT(s) FROM Shop s WHERE status = true")
    Page<Shop> findAll(Pageable pageable);

    @Query(value = "SELECT DISTINCT s FROM Shop s LEFT JOIN FETCH s.shopImages WHERE s.type IN :types AND status = true",
            countQuery = "SELECT COUNT(s) FROM Shop s WHERE s.type IN :types AND status = true")
    Page<Shop> findByTypes(@Param("types") List types, Pageable pageable);

    @Query(value = " SELECT DISTINCT s FROM Shop s LEFT JOIN FETCH s.shopImages LEFT JOIN FETCH s.tags f WHERE f.name IN :tags AND status = true",
            countQuery = "SELECT COUNT(s) FROM Shop s LEFT JOIN s.tags f WHERE f.name IN :tags AND status = true")
    Page<Shop> findByTags(@Param("tags") List tags, Pageable pageable);

    @Query(value = "SELECT DISTINCT s FROM Shop s LEFT JOIN FETCH s.shopImages LEFT JOIN FETCH s.tags f WHERE s.type IN :types AND f.name IN :tags  AND status = true",
            countQuery = "SELECT COUNT(s) FROM Shop s LEFT JOIN s.tags f  WHERE s.type IN :types AND f.name IN :tags AND status = true")
    Page<Shop> findByTypesAndTags(@Param("types") List types, @Param("tags") List tags, Pageable pageable);

    Page<Shop> findByAddressContaining(String address, Pageable pageable);

    @Query(value = "SELECT DISTINCT s FROM Shop s LEFT JOIN FETCH s.shopImages LEFT JOIN FETCH s.tags  WHERE s.id = :id")
    Shop getShopById(@Param("id") Long id);
}
