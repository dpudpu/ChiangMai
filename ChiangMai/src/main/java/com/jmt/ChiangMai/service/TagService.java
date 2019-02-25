package com.jmt.ChiangMai.service;

import com.jmt.ChiangMai.domain.Tag;
import com.jmt.ChiangMai.dto.TagDto;

import java.util.List;

public interface TagService {

    List<Tag> getTags();

    List<TagDto> getTagsDto(List<String> filters);

    void delete(Long id);

    void modify(Tag tag);

    void add(Tag tag);
}
