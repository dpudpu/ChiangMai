package com.jmt.ChiangMai.domain;

import lombok.*;

import javax.persistence.*;

@Entity
@Table
@Getter
@Setter
@NoArgsConstructor @AllArgsConstructor
@Builder
@EqualsAndHashCode
public class ShopImages {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;



}
