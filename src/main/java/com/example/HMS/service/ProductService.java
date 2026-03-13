package com.example.HMS.service;

import com.example.HMS.model.Product;
import com.example.HMS.repo.ProductRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.parameters.P;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ProductService {

    @Autowired
    private ProductRepo repo;

    public Product addProduct(Product prod){
        return repo.save(prod);
    }
    public List<Product> getAll()
    {
        return repo.findAll();
    }
    public Product getById(Long id){
        return  repo.findById(id).orElseThrow(()->new RuntimeException("product not found:"+id));
    }
    public Product upadte(Product pro){
        return repo.save(pro);
    }
    public void deleteById(Long id){
        repo.deleteById(id);
    }
}



