package com.riwi.products.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.riwi.products.entities.Product;
import com.riwi.products.repositories.ProductRepository;
import com.riwi.products.services.service_abstract.IProductService;

import lombok.AllArgsConstructor;

@Service
@AllArgsConstructor
public class ProductService implements IProductService {

    @Autowired
    private final ProductRepository productRepository;

    @Override
    public Product save(Product product) {

        return this.productRepository.save(product);
    }

    @Override
    public List<Product> getAll() {
        return this.productRepository.findAll();
    }

    @Override
    public Product findById(Long id) {
        return this.productRepository.findById(id).orElseThrow();
    }

    @Override
    public void delete(Long id) {
        Product productFind = this.productRepository.findById(id).orElseThrow();
        this.productRepository.delete(productFind);
    }

    @Override
    public Product update(Long id, Product objProduct) {
        this.productRepository.findById(id).orElseThrow();

        objProduct.setId(id);
        return this.productRepository.save(objProduct);
    }

    @Override
    public List<Product> search(String name) {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'search'");
    }

}
