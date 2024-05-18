package com.tds.product;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@CrossOrigin(origins = "*")
@RequestMapping(value = "/tds/product")
@RestController
public class ProductController {

    public final ProductService productService;

    public ProductController(ProductService productService) {
        this.productService = productService;
    }

    @GetMapping("/getAllProduct")
    public List<Product> getAllProducts() {
        return productService.getAllProduct();
    }

    @GetMapping("/getProductById")
    public Product getProductById(@RequestParam("productId") String productId) {
        return productService.getProductById(productId);
    }

    @GetMapping("/getProductByName")
    public List<Product> getProductByName(@RequestParam("productName") String productName) {
        return productService.getProductByName(productName);
    }

    // Practice: Design the delete function using product ID to delete it in Database
    @DeleteMapping("/deleteProductById")
    public String deleteProductById(@RequestParam("productId") String productId) {
        productService.deleteProductById(productId);
        return "Product deleted successfully";
    }

    // Practice: Design the create function to create a product in Database
    @PostMapping("/createProduct")
    public Product createProduct(@RequestBody Product product) {
        return productService.createProduct(product);
//        return productService.getProductById(product.getProductId());
    }
}
