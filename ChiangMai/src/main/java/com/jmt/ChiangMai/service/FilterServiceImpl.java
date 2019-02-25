package com.jmt.ChiangMai.service;

import com.jmt.ChiangMai.domain.Filter;
import com.jmt.ChiangMai.dto.FilterDto;
import com.jmt.ChiangMai.repository.FilterRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.BeanUtils;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.ArrayList;
import java.util.List;

@Service
@RequiredArgsConstructor
public class FilterServiceImpl implements FilterService {
    private final FilterRepository filterRepository;

    @Override
    @Transactional(readOnly = true)
    public List<Filter> getFilters() {
        return filterRepository.findAllByOrderByType();
    }

    @Override
    @Transactional(readOnly = true)
    public List<FilterDto> getFiltersDto(List<String> filters) {
        List<FilterDto> filterDtos = new ArrayList<>();
        List<Filter> filtersOrigin = filterRepository.findAllByOrderByType();

        for (Filter origin : filtersOrigin) {
            FilterDto target = new FilterDto();
            BeanUtils.copyProperties(origin, target);
            if (filters != null)
                target.setChecked(filters.contains(target.getName()));
            filterDtos.add(target);
        }


        return filterDtos;
    }

    @Override
    @Transactional
    public void delete(Long id) {
        filterRepository.deleteById(id);
    }

    @Override
    @Transactional
    public void modify(Filter filter) {
        BeanUtils.copyProperties(filter, filterRepository.getOne(filter.getId()));
    }

    @Override
    @Transactional
    public void add(Filter filter) {
        filterRepository.save(filter);
    }
}
