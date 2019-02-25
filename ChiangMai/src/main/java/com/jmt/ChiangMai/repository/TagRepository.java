package com.jmt.ChiangMai.repository;


import com.jmt.ChiangMai.domain.Tag;
import org.springframework.data.domain.Sort;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;
import java.util.Set;

public interface TagRepository extends JpaRepository<Tag, Long> {
    @Query(value = "SELECT f FROM Tag f WHERE type IN :types")
    List<Tag> findByTypes(@Param("types") List<String> types, Sort sort);

    @Query(value = "SELECT f FROM Tag f WHERE name IN :names")
    Set<Tag> findByName(@Param("names")List<String> names);

    List<Tag> findAllByOrderByType();
}
