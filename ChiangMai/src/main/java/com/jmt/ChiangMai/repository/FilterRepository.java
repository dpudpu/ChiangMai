package com.jmt.ChiangMai.repository;


import com.jmt.ChiangMai.domain.Filter;
import org.springframework.data.domain.Sort;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;
import java.util.Set;

public interface FilterRepository extends JpaRepository<Filter, Long> {
    @Query(value = "SELECT f FROM Filter f WHERE type IN :types")
    List<Filter> findByTypes(@Param("types") List<String> types, Sort sort);

    @Query(value = "SELECT f FROM Filter f WHERE name IN :names")
    Set<Filter> findByName(@Param("names")List<String> names);

    List<Filter> findAllByOrderByType();
}
