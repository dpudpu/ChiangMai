package com.jmt.ChiangMai.dto;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class FilterDto {
    private Long id;
    private String type;
    private String name;
    private boolean checked;
}
