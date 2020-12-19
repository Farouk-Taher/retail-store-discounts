package com.retail.store.discounts.repository;

import com.retail.store.discounts.entity.Cart;
import org.springframework.data.jpa.repository.JpaRepository;

/**
 * Created by Farouk Taher
 * Date: 19-12-2020
 * Time: 6:30 PM
 */
public interface CartRepository extends JpaRepository<Cart, Long> {
}
