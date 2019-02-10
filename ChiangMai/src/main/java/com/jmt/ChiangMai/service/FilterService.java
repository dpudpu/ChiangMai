package com.jmt.ChiangMai.service;

import com.jmt.ChiangMai.domain.Filter;
import com.jmt.ChiangMai.dto.FilterDto;
import org.springframework.data.domain.Sort;

import java.util.List;

public interface FilterService {

    List<Filter> getFilters();

    List<FilterDto> getFiltersDto(List<String> filters);

    void delete(Long id);

    void modify(Filter filter);

    void add(Filter filter);
}
