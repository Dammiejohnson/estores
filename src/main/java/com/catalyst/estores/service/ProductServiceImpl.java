package com.catalyst.estores.service;

import com.catalyst.estores.annotations.ExecutionTime;
import com.catalyst.estores.exceptions.ProductNotFoundException;
import com.catalyst.estores.model.Product;
import com.catalyst.estores.repository.ProductRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class ProductServiceImpl implements ProductService{

    private final ProductRepository productRepository;

    @ExecutionTime
    @Override
    public List<Product> getAllProducts() {
        return productRepository.findAll();
    }

    @ExecutionTime
    @Override
    public Product getProductById(Long id) {
        return productRepository.findById(id)
                .orElseThrow(() -> new ProductNotFoundException("Product not found with id: " + id));
    }

    @Override
    public Product addProduct(Product product) {
        return productRepository.save(product);

    }

    @Override
    public Product updateProduct(Long id, Product product) {
        Product existingProduct = getProductById(id);
        existingProduct.setName(product.getName());
        existingProduct.setDescription(product.getDescription());
        existingProduct.setPrice(product.getPrice());
        existingProduct.setStock(product.getStock());
        return productRepository.save(existingProduct);
    }

    @Override
    public void deleteProduct(Long id) {

    }
}
