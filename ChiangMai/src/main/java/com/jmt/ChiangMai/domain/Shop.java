package com.jmt.ChiangMai.domain;


import lombok.*;
import org.hibernate.annotations.CreationTimestamp;
import javax.persistence.*;
import java.time.LocalDateTime;
import java.util.Set;

@Entity
@Table
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
@EqualsAndHashCode(of = "id")
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

    @CreationTimestamp
    @Column(columnDefinition = "TIMESTAMP DEFAULT CURRENT_TIMESTAMP")
    private LocalDateTime regDate;

    @CreationTimestamp
    @Column(columnDefinition = "TIMESTAMP DEFAULT CURRENT_TIMESTAMP")
    protected LocalDateTime updateDate;

    @Column(nullable = false, columnDefinition = "int default 0")
    private int reviewTotal;

    @OneToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "member_id")
    private Member member;

    @ManyToMany
    @JoinTable(name = "shop_tag",
            joinColumns = @JoinColumn(name = "shop_id"),
            inverseJoinColumns = @JoinColumn(name = "tag_id"))
    private Set<Tag> tags;

    @OneToMany(cascade = CascadeType.ALL)
    @JoinColumn(name = "shop_id")
    private Set<ShopImage> shopImages;
}
