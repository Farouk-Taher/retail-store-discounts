package com.retail.store.discounts.service.impl;

import com.retail.store.discounts.dto.CartDto;
import com.retail.store.discounts.entity.Cart;
import com.retail.store.discounts.entity.Item;
import com.retail.store.discounts.entity.User;
import com.retail.store.discounts.service.CartService;
import com.retail.store.discounts.service.DiscountService;
import com.retail.store.discounts.service.UserService;
import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.time.Period;
import java.util.List;
import java.util.stream.Collectors;

/**
 * Created by Farouk Taher
 * Date: 19-12-2020
 * Time: 3:41 PM
 */
@Service
@AllArgsConstructor
@Slf4j
public class DiscountServiceImpl implements DiscountService {

    private final CartService cartService;
    private final UserService userService;

    @Override
    public Cart getFinalPrice(Long cartId, Long userId) throws Exception {
        Cart cart = cartService.getCartById(cartId);
        User user = userService.getUserById(userId);
        if (cart == null || user == null){
            log.error("User ID or cart ID in correct, user id {} cart id {]", userId, cartId);
            throw new Exception("Incorrect user id or cart id");
        }
        double groceryItemsPrice = cart.getItems().stream().mapToDouble(item -> item.getType().equals("grocery") ? item.getPrice() : 0.0).sum();

        List<Item> items = cart.getItems().stream()
                .filter(item -> !item.getType().equals("grocery")).collect(Collectors.toList());

        cart.setFinalPrice(calcDiscount(items, user) + groceryItemsPrice);
        return cartService.save(cart);
    }

    private double calcDiscount(List<Item> items, User user) {

        double finalPrice = items.stream().mapToDouble(Item::getPrice).sum();
        if (user.isEmployee()) {
            finalPrice *= 0.7;
        } else if (user.isAffiliate()) {
            finalPrice *= 0.9;
        } else if (Period.between(user.getCreationDate(), LocalDate.now()).getYears() >= 2) {
            finalPrice *= 0.95;
        } else {
            finalPrice = items.stream()
                    .mapToDouble(item -> item.getPrice() >= 100 ? item.getPrice() - 5 : item.getPrice()).sum();
        }
        return finalPrice;
    }
}
