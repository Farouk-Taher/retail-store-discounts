package com.retail.store.discounts.entity;

import lombok.Data;
import lombok.EqualsAndHashCode;

import javax.persistence.*;
import java.util.Set;

/**
 * Created by Farouk Taher
 * Date: 19-12-2020
 * Time: 4:02 PM
 */
@EqualsAndHashCode(callSuper = true)
@Data
@Entity
@Table(name = "cart")
public class Cart extends BaseEntity {

    @Id
    @Column(name = "id")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "price_before_discount")
    private Double priceBeforeDiscount;

    @Column(name = "final_price")
    private Double finalPrice;

    @OneToMany(mappedBy = "cart")
    private Set<Item> items;

}
