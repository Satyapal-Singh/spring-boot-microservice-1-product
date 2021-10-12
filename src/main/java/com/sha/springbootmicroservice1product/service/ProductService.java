package com.sha.springbootmicroservice1product.service;

import com.sha.springbootmicroservice1product.model.Product;
import com.sha.springbootmicroservice1product.repository.IProductRepository;
import org.springframework.data.domain.Example;
import org.springframework.data.domain.ExampleMatcher;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.List;
import java.util.Optional;

@Service
public class ProductService implements IProductService {
    private final IProductRepository productRepository;

    public ProductService(IProductRepository productRepository) {
        this.productRepository = productRepository;
    }

    @Override
    public List<Product> saveProduct(List<Product> products)
    {
        for (Product product : products)
        {
            product.setCreateTime(LocalDateTime.now());
        }
            return productRepository.saveAll(products);
    }

    @Override
    public void deleteProduct(Long productId)
    {
        productRepository.deleteByid(productId);
    }

    @Override
    public List<Product> findAllProducts()
    {
        return productRepository.findAll();
    }

    @Override
    public Optional<Product> showProductById(Long productId)
    {
        return productRepository.findById(productId);
    }

    @Override
    public List<Product> showProductByName(String productName)
    {
        Product p = new Product();
        p.setName(productName);
        ExampleMatcher matcher = ExampleMatcher.matchingAll()
                .withStringMatcher(ExampleMatcher.StringMatcher.CONTAINING)
                .withIgnoreCase()
                .withIgnorePaths("id");
        Example<Product> prodEx = Example.of(p,matcher);
        return productRepository.findAll(prodEx);
    }

    @Override
    public List<Product> getProductByPrice(Double productPrice)
    {
        Product p = new Product();
        p.setPrice(productPrice);
        ExampleMatcher matcher = ExampleMatcher.matching()
                .withStringMatcher(ExampleMatcher.StringMatcher.STARTING)
                .withIgnorePaths("id");
        Example<Product> prodEx = Example.of(p,matcher);
        return productRepository.findAll(prodEx);

    }
    @Override
    public void deleteAllProducts()
    {
        productRepository.deleteAll();
    }
}
