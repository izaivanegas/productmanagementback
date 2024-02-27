package com.example.products.controller;

import com.example.products.model.Product;
import com.example.products.service.ProductService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@CrossOrigin(origins = "http://localhost:3000")
@RestController
@RequestMapping("/products")
@Slf4j
public class ProductController {
    private final ProductService productService;
    public ProductController(ProductService productService) {
        this.productService = productService;
    }

    @GetMapping("/all")
    public ResponseEntity<?> getAllProduct(){
        return new ResponseEntity<>( productService.getAllProducts(), HttpStatus.OK);
    }
    @PostMapping("/saveProduct")
    public ResponseEntity<?> saveNewProduct(@RequestBody Product product){
        log.info("Esto es un mensahe");
        return new ResponseEntity<>(productService.saveProduct(product),HttpStatus.CREATED);
    }
    @GetMapping("/{id}")
    public ResponseEntity<?> getProductById(@PathVariable("id") Integer id){
        return new ResponseEntity<>(productService.getProductById(id),HttpStatus.OK);
    }
    @DeleteMapping("/delete/{id}")
    public ResponseEntity<?> deleteProduct(@PathVariable("id") Integer id){
        return new ResponseEntity<>(
                productService.deleteProduct(id), HttpStatus.OK
        );
    }

    @PutMapping("/editProduct/{id}")
    public ResponseEntity<?> updateProduct(@RequestBody Product product, @PathVariable("id") Integer id){
        return new ResponseEntity<>(productService.updateProduct(product, id),HttpStatus.OK);
    }





}
