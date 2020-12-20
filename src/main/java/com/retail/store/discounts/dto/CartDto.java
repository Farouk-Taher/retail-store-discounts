package com.retail.store.discounts.dto;

import com.retail.store.discounts.entity.Item;
import lombok.Data;

import java.time.LocalDate;
import java.util.Set;

/**
 * Created by Farouk Taher
 * Date: 20-12-2020
 * Time: 11:06 AM
 */
@Data
public class CartDto {
    private Long id;

    private Double priceBeforeDiscount;

    private Double finalPrice;

    private Set<Item> items;

    private LocalDate creationDate;

    private LocalDate lastModificationDate;

}
