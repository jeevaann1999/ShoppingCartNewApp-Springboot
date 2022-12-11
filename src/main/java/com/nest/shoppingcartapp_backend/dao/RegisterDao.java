package com.nest.shoppingcartapp_backend.dao;

import com.nest.shoppingcartapp_backend.model.UserRegister;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;

import java.util.List;

public interface RegisterDao extends CrudRepository<UserRegister, Integer> {
    @Query(value ="SELECT `id`, `address`, `confirm`, `email`, `name`, `password`, `phone` FROM `user` WHERE `email`=:email AND `password`=:password",nativeQuery = true)
    List<UserRegister> FindUserLogin(@Param("email") String email,@Param("password") String password);
}
