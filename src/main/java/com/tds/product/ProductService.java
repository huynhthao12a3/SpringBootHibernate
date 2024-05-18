package com.tds.product;

import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ProductService {
    private IProductRepository productRepository;

    public ProductService(IProductRepository productRepository) {
        this.productRepository = productRepository;
    }
    public List<Product> getAllProduct() {
        return productRepository.findAll();
    }

    public Product getProductById(String productId) {
        return productRepository.findById(productId).get();
    }

    public List<Product> getProductByName(String productName) {
        return productRepository.findProductListByName(productName);
    }

    public void deleteProductById(String productId) {
        productRepository.deleteById(productId);
    }

    public Product createProduct(Product product) {
        return productRepository.save(product);
    }
}
