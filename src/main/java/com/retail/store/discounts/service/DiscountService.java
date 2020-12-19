package com.retail.store.discounts.service;

import com.retail.store.discounts.entity.Cart;
import com.retail.store.discounts.entity.User;

/**
 * Created by Farouk Taher
 * Date: 19-12-2020
 * Time: 3:14 PM
 */
public interface DiscountService {

    public Cart getFinalPrice(Cart cart, User user);
}
