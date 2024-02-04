package com.sh.app.products.service;

import com.sh.app.products.entity.Product;
import com.sh.app.products.repository.ProductsRepository;
import jakarta.transaction.Transactional;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

@Service
@Transactional
@RequiredArgsConstructor
public class ProductsService {
    private final ProductsRepository productsRepository;

    public ResponseEntity<?> findById(Long id) {
        Product product = productsRepository.findById(id).orElse(null);
        if(product != null)
            return ResponseEntity.ok(product.getName());
        else
            return ResponseEntity.notFound().build();
    }
}
