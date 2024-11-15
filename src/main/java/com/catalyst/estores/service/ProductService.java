package com.catalyst.estores.service;

import com.catalyst.estores.model.Product;
import java.util.List;


public interface ProductService {

    List<Product> getAllProducts();
    Product getProductById(Long id);
    Product addProduct(Product product);
    Product updateProduct(Long id, Product product);
    void deleteProduct(Long id);

}
