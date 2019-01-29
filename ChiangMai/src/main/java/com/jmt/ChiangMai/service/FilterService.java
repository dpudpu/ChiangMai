package com.jmt.ChiangMai.service;

import com.jmt.ChiangMai.domain.Filter;
import org.springframework.data.domain.Sort;

import java.util.List;

public interface FilterService {

    List<Filter> getFilters(List<String> types, Sort sort);

    void delete(Long id);

    void modify(Filter filter);

    void add(Filter filter);
}
