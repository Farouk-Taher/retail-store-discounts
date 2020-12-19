package com.retail.store.discounts.repository;

import com.retail.store.discounts.entity.Employee;
import org.springframework.data.jpa.repository.JpaRepository;

/**
 * Created by Farouk Taher
 * Date: 19-12-2020
 * Time: 2:58 PM
 */
public interface EmployeeRepository extends JpaRepository<Employee, Long> {

}
