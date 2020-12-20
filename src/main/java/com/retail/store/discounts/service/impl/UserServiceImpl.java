package com.retail.store.discounts.service.impl;

import com.retail.store.discounts.entity.User;
import com.retail.store.discounts.repository.UserRepository;
import com.retail.store.discounts.service.UserService;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

/**
 * Created by Farouk Taher
 * Date: 19-12-2020
 * Time: 2:59 PM
 */
@Service
@AllArgsConstructor
public class UserServiceImpl implements UserService {

    private final UserRepository repository;

    @Override
    public User getUserById(Long userId) {
        return repository.findById(userId).orElse(null);
    }
}
