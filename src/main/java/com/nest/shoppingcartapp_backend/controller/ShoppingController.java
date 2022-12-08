package com.nest.shoppingcartapp_backend.controller;


import com.nest.shoppingcartapp_backend.dao.ProductDao;
import com.nest.shoppingcartapp_backend.dao.RegisterDao;
import com.nest.shoppingcartapp_backend.model.Product;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class ShoppingController {
    @Autowired
    private ProductDao dao;

    @Autowired
    private RegisterDao d;
    @PostMapping("/add")
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

    @GetMapping("/view")
    public String ViewProduct()
    {
        return "Welcome to the view page";
    }
    @PostMapping("/search")
    public String SearchProduct()
    {
        return "Welcome to the search product page";
    }

}
