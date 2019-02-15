package com.jmt.ChiangMai.repository;

import com.jmt.ChiangMai.domain.Shop;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;

public interface ShopRepository extends JpaRepository<Shop, Long> {
    //TODO fetch join

    @Query(value = "SELECT DISTINCT s FROM Shop s LEFT JOIN FETCH s.shopImages",
            countQuery = "SELECT COUNT(s) FROM Shop s ")
    Page<Shop> findAll(Pageable pageable);

    @Query(value = "SELECT DISTINCT s FROM Shop s LEFT JOIN FETCH s.shopImages WHERE type IN :types",
            countQuery = "SELECT COUNT(s) FROM Shop s WHERE type IN :types")
    Page<Shop> findByTypes(@Param("types") List types, Pageable pageable);

    @Query(value = " SELECT DISTINCT s FROM Shop s LEFT JOIN FETCH s.shopImages LEFT JOIN FETCH s.filters f WHERE f.name IN :filters",
            countQuery = "SELECT COUNT(s) FROM Shop s LEFT JOIN s.filters f WHERE f.name IN :filters")
    Page<Shop> findByFilters(@Param("filters") List filters, Pageable pageable);

    @Query(value = "SELECT DISTINCT s FROM Shop s LEFT JOIN FETCH s.shopImages LEFT JOIN FETCH s.filters f WHERE s.type IN :types AND f.name IN :filters",
            countQuery = "SELECT COUNT(s) FROM Shop s LEFT JOIN s.filters f  WHERE s.type IN :types AND f.name IN :filters")
    Page<Shop> findByTypesAndFilters(@Param("types") List types, @Param("filters") List filters, Pageable pageable);

    Page<Shop> findByAddressContaining(String address, Pageable pageable);

    /*
    SELECT DISTINCT s.id, s.name ,s.type, f.name
    FROM shop s
    INNER JOIN shop_filter sf
    INNER JOIN filter f
    ON s.id = sf.shop_id AND sf.filter_id = f.id
    WHERE s.type IN("식당","마사지") AND f.name IN("일식");
     */
    @Query(value = "SELECT DISTINCT s FROM Shop s LEFT JOIN FETCH s.shopImages LEFT JOIN FETCH s.reviews LEFT JOIN FETCH s.filters WHERE s.id = :id")
    Shop getShopById(@Param("id") Long id);
}
