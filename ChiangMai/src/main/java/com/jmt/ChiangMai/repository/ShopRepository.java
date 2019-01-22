package com.jmt.ChiangMai.repository;

import com.jmt.ChiangMai.domain.Shop;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;

public interface ShopRepository extends JpaRepository<Shop, Long> {

    @Query(value = "SELECT s FROM Shop s WHERE type IN :types")
    List<Shop> findByType(@Param("types") List types, Pageable pageable);

    List<Shop> findByAddressContaining(String address);

    @Query(value = "SELECT s FROM Shop s WHERE s.open < :time AND s.close > :time ")
    List<Shop> findByOpenAfterAndCloseBefore(@Param("time") Long time);

    /*
    SELECT DISTINCT s.id, s.name , f.name
    FROM shop s
    INNER JOIN shop_filter sf
    INNER JOIN filter f
    ON s.id = sf.shop_id AND sf.filter_id = f.id
    WHERE f.name IN("일식","한식") AND s.type IN("식당");
     */
    @Query(value = "SELECT DISTINCT s FROM Shop s LEFT JOIN s.filters f WHERE s.type IN :types AND f.name IN :filters")
    List<Shop> findByTypeAndFilters(@Param("types") List types, @Param("filters") List filters, Pageable pageable);
}
