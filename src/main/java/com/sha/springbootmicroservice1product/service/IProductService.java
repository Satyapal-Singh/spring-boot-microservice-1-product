package com.sha.springbootmicroservice1product.service;

import com.sha.springbootmicroservice1product.model.Product;

import java.util.List;
import java.util.Optional;

public interface IProductService
{
    public List<Product> saveProduct(List<Product> product);
    public void deleteProduct(Long productId);
    public List<Product> findAllProducts();
    public Optional<Product> showProductById(Long productId);
    public List<Product> showProductByName(String productName);
    public List<Product> getProductByPrice(Double productPrice);
    public void deleteAllProducts();
}