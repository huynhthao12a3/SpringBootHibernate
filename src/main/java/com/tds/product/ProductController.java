package com.tds.product;

import com.tds.response.ResponseObject;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Objects;

@CrossOrigin(origins = "*")
@RequestMapping(value = "/tds/product")
@RestController
public class ProductController {
    public final ProductService productService;


    public ProductController(ProductService productService) {
        this.productService = productService;
    }

    @GetMapping("/get-all-product")
    public ResponseObject<List<Product>> getAllProducts() {
//        ResponseObject<List<Product>> responseObject = new ResponseObject<>();
//        responseObject.setIsSuccess(true);
//        responseObject.setMessage("Success");
//        responseObject.setStatus(String.valueOf(HttpStatus.OK.value()));
//        responseObject.setData(productService.getAllProduct());

//        return responseObject(true, String.valueOf(HttpStatus.OK.value()), "Success", productService.getAllProduct());
        return new ResponseObject<>(true, String.valueOf(HttpStatus.OK.value()), "Success", productService.getAllProduct());
    }

    @GetMapping("/get-product-by-id")
    public ResponseObject<Product> getProductById(@RequestParam("productId") String productId) {
        return new ResponseObject<>(true, String.valueOf(HttpStatus.OK.value()), "Success", productService.getProductById(productId));
    }

    @GetMapping("/get-product-by-name")
    public ResponseObject<List<Product>> getProductByName(@RequestParam("productName") String productName) {
        return new ResponseObject<>(true, String.valueOf(HttpStatus.OK.value()), "Success", productService.getProductByName(productName));
    }

    @DeleteMapping("/delete-product-by-id")
    public ResponseObject<String> deleteProductById(@RequestParam("productId") String productId) {
        productService.deleteProductById(productId);
        return new ResponseObject<>(true, String.valueOf(HttpStatus.OK.value()), "Product deleted successfully", productId);
    }

    @PostMapping("/create-product")
    public ResponseObject<Product> createProduct(@RequestBody @Valid Product product) {
        System.out.println(product);
        return new ResponseObject<>(true, String.valueOf(HttpStatus.OK.value()), "Success", productService.createProduct(product));
    }
}
