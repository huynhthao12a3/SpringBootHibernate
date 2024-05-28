package com.tds.product;

import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ProductService {
    private final IProductRepository productRepository;

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
        return productRepository.findProductListByName(productName.toUpperCase());
    }

    public void deleteProductById(String productId) {
        productRepository.deleteById(productId);
    }

    public Product createProduct(Product product) {
        System.out.println(product.getProductId());
        return productRepository.save(product);
    }
}
