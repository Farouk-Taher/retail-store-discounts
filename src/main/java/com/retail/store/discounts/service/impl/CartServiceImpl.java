package com.retail.store.discounts.service.impl;

import com.retail.store.discounts.entity.Cart;
import com.retail.store.discounts.repository.CartRepository;
import com.retail.store.discounts.service.CartService;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

/**
 * Created by Farouk Taher
 * Date: 19-12-2020
 * Time: 7:23 PM
 */
@Service
@AllArgsConstructor
public class CartServiceImpl implements CartService {

    private final CartRepository repository;

    @Override
    public Cart save(Cart cart) {
        return repository.save(cart);
    }

    @Override
    public Cart getCartById(Long id) {
        return repository.findById(id).orElse(null);
    }


}
