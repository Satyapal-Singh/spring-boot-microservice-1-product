package com.sha.springbootmicroservice1product.controller;
import com.sha.springbootmicroservice1product.model.Product;
import com.sha.springbootmicroservice1product.service.IProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.transaction.Transactional;
import java.util.List;

@RestController
@RequestMapping("api/product")
public class ProductController
{
    @Autowired
    private IProductService productService;

    @PostMapping
    public ResponseEntity<?> saveProduct(@RequestBody List<Product> products)
    {
        return new ResponseEntity<>(productService.saveProduct(products), HttpStatus.CREATED);
    }

    @Transactional
    @DeleteMapping("{productId}")
    public ResponseEntity<?> deleteProduct(@PathVariable Long productId)
    {
        productService.deleteProduct(productId);
        return new ResponseEntity<>(HttpStatus.OK);
    }

    @GetMapping
    public ResponseEntity<?> getAllProducts()
    {
        return ResponseEntity.ok(productService.findAllProducts());
    }

    @GetMapping("{productId}")
    public ResponseEntity<?> getProductById(@PathVariable Long productId)
    {
        return ResponseEntity.ok(productService.showProductById(productId));
    }

    @GetMapping("getByName/{productName}")
    public ResponseEntity<?> getProductById(@PathVariable String productName)
    {
        return ResponseEntity.ok(productService.showProductByName(productName));
    }

    @GetMapping("getByPrice/{productPrice}")
    public ResponseEntity<?> getProductByPrice(@PathVariable Double productPrice)
    {
        return ResponseEntity.ok(productService.getProductByPrice(productPrice));
    }

    @Transactional
    @DeleteMapping
    public ResponseEntity<?> deleteAllProducts()
    {
        productService.deleteAllProducts();
        return new ResponseEntity<>(HttpStatus.OK);
    }
}
