package com.retail.store.discounts.repository;

import com.retail.store.discounts.entity.User;
import org.springframework.data.jpa.repository.JpaRepository;

/**
 * Created by Farouk Taher
 * Date: 19-12-2020
 * Time: 2:57 PM
 */
public interface UserRepository extends JpaRepository<User, Long> {
}
