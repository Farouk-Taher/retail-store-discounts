package com.retail.store.discounts.entity;

import lombok.Data;
import lombok.EqualsAndHashCode;

import javax.persistence.*;

/**
 * Created by Farouk Taher
 * Date: 19-12-2020
 * Time: 4:03 PM
 */
@EqualsAndHashCode(callSuper = true)
@Entity
@Table(name = "item")
@Data
public class Item extends BaseEntity {

    @Id
    @Column(name = "id")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "price", nullable = false)
    private double price;

    @Column(name = "name", nullable = false)
    private String name;

    @Column(name = "type")
    private String type;

    @ManyToOne
    @JoinColumn(name = "cart_id")
    private Cart cart;
}
