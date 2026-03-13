package com.example.HMS.controller;

import com.example.HMS.model.Product;
import com.example.HMS.service.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/product")
public class ProductController {

    @Autowired
    private ProductService ser;

    @PostMapping("/save")
    public ResponseEntity<Product> addProduct(@RequestBody Product prod) {
        Product savedProduct = ser.addProduct(prod);
        return ResponseEntity.ok(savedProduct);
    }

    @PutMapping("/{id}")
    public ResponseEntity<Product> getById(@PathVariable long id,@RequestBody Product prod){

        Product d= ser.getById(id);
        d.setId(prod.getId());
        d.setPrdName(prod.getPrdName());
        d.setPrice(prod.getPrice());
        return ResponseEntity.ok(d);
    }
    @GetMapping("/all")
    public ResponseEntity<List<Product>>getAll(){
        return ResponseEntity.ok(ser.getAll());
    }
    @GetMapping("/{id}")
    public ResponseEntity<Product> getById(@PathVariable Long id){
        return ResponseEntity.ok(ser.getById(id));
    }
    @DeleteMapping("/{id}")
    public ResponseEntity<String> deleteById(@PathVariable Long id){
        ser.deleteById(id);
        return ResponseEntity.ok("Product deleted successfully");
    }

}