package com.nest.shoppingcartapp_backend.controller;


import com.nest.shoppingcartapp_backend.dao.ProductDao;
import com.nest.shoppingcartapp_backend.dao.RegisterDao;
import com.nest.shoppingcartapp_backend.model.Product;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class ShoppingController {
    @Autowired
    private ProductDao dao;

    @Autowired
    private RegisterDao d;

    @CrossOrigin(origins = "*")
    @PostMapping(path = "/add",consumes = "application/json", produces = "application/json")
    public String AddProduct(@RequestBody Product p)
    {
        System.out.println(p.getName().toString());
        System.out.println(p.getImage().toString());
        System.out.println(p.getCategory().toString());
        System.out.println(p.getPrice());
        System.out.println(p.getDescription().toString());
        dao.save(p);
        return "Welcome to the add page";
    }

    @CrossOrigin(origins = "*")
    @GetMapping("/view")
    public List<Product> ViewProduct()
    {
        return (List<Product>) dao.findAll();
    }
    @CrossOrigin(origins = "*")
    @PostMapping("/search")
    public String SearchProduct()
    {
        return "Welcome to the search product page";
    }

}
