package com.sha.springbootmicroservice1product.service;

import com.sha.springbootmicroservice1product.model.Product;

import java.util.List;

public interface IProductService
{
    public Product saveProduct(Product product);
    public void deleteProduct(Long productId);
    public List<Product> findAllProducts();
}