package com.retail.store.discounts.entity;

import lombok.Data;
import lombok.EqualsAndHashCode;

import javax.persistence.*;
import java.time.LocalDate;

/**
 * Created by Farouk Taher
 * Date: 17-12-2020
 * Time: 8:08 PM
 */
@Entity
@Table("employee")
@Data
@EqualsAndHashCode(callSuper = true)
public class Employee extends BaseEntity {

    @Id
    @Column("id")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "name", nullable = false)
    private String name;

    @Column(name = "email", nullable = false, unique = true)
    private String email;

    @Column(name = "joining_date", nullable = false)
    private LocalDate joiningDate;

    @Column(name = "status", nullable = false)
    private String status;

}

