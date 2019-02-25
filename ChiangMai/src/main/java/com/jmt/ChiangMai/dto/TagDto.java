package com.jmt.ChiangMai.dto;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class TagDto {
    private Long id;
    private String type;
    private String name;
    private boolean checked;
}
