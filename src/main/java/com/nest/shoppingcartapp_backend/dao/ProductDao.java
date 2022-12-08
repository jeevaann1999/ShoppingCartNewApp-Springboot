package com.nest.shoppingcartapp_backend.dao;

import com.nest.shoppingcartapp_backend.model.Product;
import org.springframework.data.repository.CrudRepository;

public interface ProductDao extends CrudRepository<Product,Integer> {
}
