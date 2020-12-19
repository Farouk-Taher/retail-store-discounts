package com.retail.store.discounts.entity;

import lombok.Data;
import lombok.EqualsAndHashCode;

import javax.persistence.*;

/**
 * Created by Farouk Taher
 * Date: 17-12-2020
 * Time: 8:41 PM
 */
@EqualsAndHashCode(callSuper = true)
@Entity
@Table("user")
@Data
public class User extends BaseEntity {

    @Id
    @Column("id")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "name", nullable = false)
    private String name;

    @Column(name = "email", nullable = false, unique = true)
    private String email;

    @Column(name = "is_employee")
    private Boolean isEmployee;

    @Column(name = "is_affiliate")
    private Boolean isAffiliate;

}
