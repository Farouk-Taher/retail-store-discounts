package com.retail.store.discounts.entity;

import lombok.Data;

import javax.persistence.Column;
import javax.persistence.MappedSuperclass;
import java.io.Serializable;
import java.time.LocalDate;

/**
 * Created by Farouk Taher
 * Date: 17-12-2020
 * Time: 8:16 PM
 */
@Data
@MappedSuperclass
public abstract class BaseEntity implements Serializable {

    private static final long serialVersionUID = 1L;

    @Column("creation_date")
    private LocalDate creationDate;

    @Column("last_modification_date")
    private LocalDate lastModificationDate;

}
