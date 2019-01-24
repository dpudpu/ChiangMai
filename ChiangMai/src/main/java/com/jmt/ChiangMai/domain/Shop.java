package com.jmt.ChiangMai.domain;

import lombok.*;

import javax.persistence.*;
import java.util.Date;
import java.util.Set;

@Entity
@Table
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
@EqualsAndHashCode
public class Shop {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(nullable = false)
    private String type;

    @Column(unique = true, nullable = false)
    private String name;

    @Column
    private String phone;

    @Column(nullable = false)
    private String address;

    @Column
    private Long open;

    @Column
    private Long close;

    @Column
    private String content;

    @Column(nullable = false, columnDefinition = "int default 0")
    private int rating;

    @Temporal(TemporalType.TIMESTAMP)
    @Column(columnDefinition = "TIMESTAMP DEFAULT CURRENT_TIMESTAMP")
    private Date regDate;

    @Temporal(TemporalType.TIMESTAMP)
    @Column(columnDefinition = "TIMESTAMP DEFAULT CURRENT_TIMESTAMP")
    private Date updateDate;

    @Column(nullable = false, columnDefinition = "int default 0")
    private int hit;

    @OneToOne
    @JoinColumn(name = "member_id")
    private Member member;

    @OneToMany
    @JoinColumn(name = "shop_id")
    private Set<Review> reviews;

    @ManyToMany
    @JoinTable(name = "shop_filter",
            joinColumns = @JoinColumn(name = "shop_id"),
            inverseJoinColumns = @JoinColumn(name = "filter_id"))
    private Set<Filter> filters;

    @OneToMany(cascade = CascadeType.ALL)
    @JoinColumn(name = "shop_id")
    private Set<ShopImage> shopImages;
}
