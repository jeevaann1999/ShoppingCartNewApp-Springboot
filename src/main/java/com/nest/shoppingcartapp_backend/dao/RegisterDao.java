package com.nest.shoppingcartapp_backend.dao;

import com.nest.shoppingcartapp_backend.model.UserRegister;
import org.springframework.data.repository.CrudRepository;

public interface RegisterDao extends CrudRepository<UserRegister, Integer> {
}
