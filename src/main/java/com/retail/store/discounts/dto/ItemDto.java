package com.retail.store.discounts.dto;

import lombok.Data;

import java.time.LocalDate;

/**
 * Created by Farouk Taher
 * Date: 20-12-2020
 * Time: 11:07 AM
 */
@Data
public class ItemDto {
    private Long id;

    private double price;

    private String name;

    private String type;

    private LocalDate creationDate;

    private LocalDate lastModificationDate;

}
