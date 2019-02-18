package com.jmt.ChiangMai.domain.enums;

import lombok.AllArgsConstructor;
import lombok.Getter;

@Getter
@AllArgsConstructor
public enum PageSize {
    REVIEW(5);
    private final int limit;
}
