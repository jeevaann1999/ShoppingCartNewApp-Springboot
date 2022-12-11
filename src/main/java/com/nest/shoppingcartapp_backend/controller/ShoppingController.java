package com.nest.shoppingcartapp_backend.controller;


import com.nest.shoppingcartapp_backend.dao.ProductDao;
import com.nest.shoppingcartapp_backend.dao.RegisterDao;
import com.nest.shoppingcartapp_backend.model.Product;
import com.nest.shoppingcartapp_backend.model.UserRegister;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import javax.lang.model.util.Elements;
import java.util.HashMap;
import java.util.List;

@RestController
public class ShoppingController {
    @Autowired
    private ProductDao dao;

    @Autowired
    private RegisterDao d;

    @CrossOrigin(origins = "*")
    @PostMapping(path = "/userlogin",consumes = "application/json", produces = "application/json")
    public HashMap<String, String> UserLogin(@RequestBody UserRegister ul){
        System.out.println(ul.getEmail());
        List<UserRegister> result= (List<UserRegister>) d.FindUserLogin(ul.getEmail(),ul.getPassword());
        System.out.println(result);
        HashMap<String,String> st=new HashMap<>();
        if(result.size()==0) {
            st.put("status", "failed");
            st.put("message", "user doesn't exist");
        }
        else {
            int id =result.get(0).getId();
            st.put("userId",String.valueOf(id));
            st.put("status", "success");
            st.put("message", "user login success");
        }
        return st;
    }

    @CrossOrigin(origins = "*")
    @PostMapping(path = "/getUserById",consumes = "application/json",produces = "application/json")
    public List<UserRegister> GetUserById(@RequestBody UserRegister u)
    {
        return (List<UserRegister>) d.FindUser(u.getId());
    }


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
    @PostMapping(path = "/search",consumes = "application/json",produces = "application/json")
    public List<Product> SearchProduct(@RequestBody Product p)
    {
        String name=p.getName().toString();
        System.out.println(name);
        return (List<Product>) dao.SearchProduct(p.getName());
    }
    @CrossOrigin(origins = "*")
    @PostMapping("/register")
    public String UserRegister(@RequestBody UserRegister u)
    {
        System.out.println(u.getName().toString());
        System.out.println(u.getAddress().toString());
        System.out.println(u.getPhone().toString());
        System.out.println(u.getEmail().toString());
        System.out.println(u.getPassword().toString());
        System.out.println(u.getConfirm().toString());
        d.save(u);
        return "welcome";
    }



}
