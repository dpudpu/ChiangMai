package com.jmt.ChiangMai.domain;

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonManagedReference;
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
    private Double lat;

    @Column
    private Double lng;

    @Column(nullable = false, columnDefinition = "boolean default true")
    private boolean status;

    @Column
    private Long open;

    @Column
    private Long close;

    @Column
    @Lob
    private String content;

    @Column(nullable = false, columnDefinition = "float default 0")
    private float rating;

    @Temporal(TemporalType.TIMESTAMP)
    @Column(columnDefinition = "TIMESTAMP DEFAULT CURRENT_TIMESTAMP")
    private Date regDate;

    @Temporal(TemporalType.TIMESTAMP)
    @Column(columnDefinition = "TIMESTAMP DEFAULT CURRENT_TIMESTAMP")
    private Date updateDate;

    @Column(nullable = false, columnDefinition = "int default 0")
    private int reviewTotal;

    @OneToOne(fetch=FetchType.LAZY)
    @JoinColumn(name = "member_id")
    private Member member;

    @OneToMany(mappedBy = "shop")
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
