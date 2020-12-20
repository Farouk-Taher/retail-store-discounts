package com.retail.store.discounts.controller;

import com.retail.store.discounts.dto.CartDto;
import com.retail.store.discounts.entity.Cart;
import com.retail.store.discounts.service.DiscountService;
import com.retail.store.discounts.util.MapperUtils;
import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * Created by Farouk Taher
 * Date: 20-12-2020
 * Time: 11:04 AM
 */
@RestController
@AllArgsConstructor
@Slf4j
@RequestMapping("/api")
public class DiscountController {

    private final DiscountService discountService;

    @GetMapping("/get-cart-final-price")
    public ResponseEntity<CartDto> getCartFinalPrice(Long cartId, Long userId) throws Exception {
        log.info("Get cart final price request received");
        Cart cart = discountService.getFinalPrice(cartId, userId);
        return new ResponseEntity<>(MapperUtils.map(cart, CartDto.class), HttpStatus.OK);
    }
}
