package com.jmt.ChiangMai.dto;

import com.jmt.ChiangMai.domain.Filter;
import com.jmt.ChiangMai.domain.ShopImage;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class ShopDto {
    private Long id;
    private String type;
    private String name;
    private String address;
    private Double lat;
    private Double lng;
    private Long open;
    private Long close;
    private String content;
    private Double rating;
    private Double reviewTotal;
    private ShopImage shopImages;
}
