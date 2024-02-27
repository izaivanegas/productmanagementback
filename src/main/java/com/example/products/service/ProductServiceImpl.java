package com.example.products.service;

import com.example.products.model.Product;
import com.example.products.repository.ProductRepository;
import org.springframework.stereotype.Service;

import java.util.List;


@Service
public class ProductServiceImpl implements ProductService{
    private final ProductRepository productRepository;

    public ProductServiceImpl(ProductRepository productRepository) {
        this.productRepository = productRepository;
    }

    @Override
    public Product saveProduct(Product product) {
        return productRepository.save(product);
    }

    @Override
    public Product getProductById(Integer id) {
        return productRepository.findById(id).get();
    }

    @Override
    public List<Product> getAllProducts() {
        return productRepository.findAll();
    }

    @Override
    public String deleteProduct(Integer id) {
        Product product = productRepository.findById(id).get();
        if( product != null ){
            productRepository.delete(product);
            return "Product deleted";
        }
        return "somethinf wrong with the server";
    }

    @Override
    public Product updateProduct(Product product,Integer id) {
        Product product1 = productRepository.findById(id).get();
        if(product1 != null ){
            product1.setProductName(product.getProductName());
            product1.setDescription(product.getDescription());
            product1.setPrice(product.getPrice());
            product1.setStatus(product.getStatus());
            return productRepository.save(product1);
        }
        return product1;
    }
}
