package com.retail.store.discounts.service;

import com.retail.store.discounts.entity.Cart;

/**
 * Created by Farouk Taher
 * Date: 19-12-2020
 * Time: 7:22 PM
 */
public interface CartService {

    public Cart save(Cart cart);

    public Cart getCartById(Long id);
}
