package com.nest.shoppingcartapp_backend.dao;

import com.nest.shoppingcartapp_backend.model.Product;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;

import java.util.List;

public interface ProductDao extends CrudRepository<Product,Integer> {
    @Query(value = "SELECT `id`, `category`, `description`, `image`, `name`, `price` FROM `products` WHERE `name`LIKE %:name%",nativeQuery = true)
    List<Product> SearchProduct(@Param("name")String name);
}
