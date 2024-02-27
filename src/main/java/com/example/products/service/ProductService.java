package com.example.products.service;

import com.example.products.model.Product;
import java.util.List;

public interface ProductService{
    public Product saveProduct(Product product);
    public Product getProductById(Integer id);
    public List<Product> getAllProducts();
    public String deleteProduct(Integer id);
    public Product updateProduct( Product product, Integer id);
}
