package com.jmt.ChiangMai.service;

import com.jmt.ChiangMai.domain.Tag;
import com.jmt.ChiangMai.dto.TagDto;
import com.jmt.ChiangMai.repository.TagRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.BeanUtils;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.ArrayList;
import java.util.List;

@Service
@RequiredArgsConstructor
public class TagServiceImpl implements TagService {
    private final TagRepository tagRepository;

    @Override
    @Transactional(readOnly = true)
    public List<Tag> getTags() {
        return tagRepository.findAllByOrderByType();
    }

    @Override
    @Transactional(readOnly = true)
    public List<TagDto> getTagsDto(List<String> tags) {
        List<TagDto> tagDtos = new ArrayList<>();
        List<Tag> tagsOrigin = tagRepository.findAllByOrderByType();

        for (Tag origin : tagsOrigin) {
            TagDto target = new TagDto();
            BeanUtils.copyProperties(origin, target);
            if (tags != null)
                target.setChecked(tags.contains(target.getName()));
            tagDtos.add(target);
        }


        return tagDtos;
    }

    @Override
    @Transactional
    public void delete(Long id) {
        tagRepository.deleteById(id);
    }

    @Override
    @Transactional
    public void modify(Tag tag) {
        BeanUtils.copyProperties(tag, tagRepository.getOne(tag.getId()));
    }

    @Override
    @Transactional
    public void add(Tag tag) {
        tagRepository.save(tag);
    }
}
