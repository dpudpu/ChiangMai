package com.jmt.ChiangMai.domain;

import lombok.*;

import javax.persistence.*;

@Entity
@Table
@Getter
@Setter
@NoArgsConstructor
@Builder
@EqualsAndHashCode
public class ShopImages {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;



}
