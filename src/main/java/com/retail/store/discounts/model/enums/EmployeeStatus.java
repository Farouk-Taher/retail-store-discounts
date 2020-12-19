package com.retail.store.discounts.model.enums;

import lombok.AllArgsConstructor;
import lombok.Getter;

/**
 * Created by Farouk Taher
 * Date: 17-12-2020
 * Time: 8:33 PM
 */
@Getter
@AllArgsConstructor
public enum EmployeeStatus {

    ACTIVE("active"),
    INACTIVE("inactive");

    private final String description;

}
