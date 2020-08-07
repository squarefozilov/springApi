package com.javatechie.crud.example.controller;
import com.javatechie.crud.example.entity.Product;
import com.javatechie.crud.example.service.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.HashMap;
import java.util.*;
import java.util.LinkedList;
import java.util.List;

@RestController
public class ProductController {

    @Autowired
    private ProductService service;
    @GetMapping("/")
    public HashMap<Integer,String > findAll()
    {
        List<String> mylist = new LinkedList<>();
        mylist.add("one");
        mylist.add("two");

        HashMap<Integer,String> myHash = new HashMap<Integer, String>();
        myHash.put(1,"Abbos");
        myHash.put(32, "Faruh");
        //mylist.add(56,myHash.toString());
        if(myHash.containsValue("Abbos"))
        {
          myHash.put(1,"Fozilo");
        }
        Random random = new Random();
        //random.ints().limit(10).forEach(System.out::println);

        List<String>strings = Arrays.asList("abc", "", "bc", "efg", "abcd","", "jkl");
       
        return myHash;
    }

    @PostMapping("/addProduct")
    public Product addProduct(@RequestBody Product product) {
        return service.saveProduct(product);
    }

    @PostMapping("/addProducts")
    public List<Product> addProducts(@RequestBody List<Product> products) {
        System.out.println( " -- " + products);
        return service.saveProducts(products);
    }

    @GetMapping("/products")
    public List<Product> findAllProducts() {
        return service.getProducts();
    }

    @GetMapping("/productById/{id}")
    public Product findProductById(@PathVariable int id) {
        return service.getProductById(id);
    }

    @GetMapping("/product/{name}")
    public Product findProductByName(@PathVariable String name) {
        return service.getProductByName(name);
    }

    @PutMapping("/update")
    public Product updateProduct(@RequestBody Product product) {
        return service.updateProduct(product);
    }

    @DeleteMapping("/delete/{id}")
    public String deleteProduct(@PathVariable int id) {
        return service.deleteProduct(id);
    }
}
