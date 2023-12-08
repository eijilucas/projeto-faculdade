
package com.projetofaculdade.fasterfood.controllers;

import com.projetofaculdade.fasterfood.controllers.services.ProductServices;
import com.projetofaculdade.fasterfood.entities.Order;
import com.projetofaculdade.fasterfood.entities.Product;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;


@RestController
@CrossOrigin("*")
@RequestMapping("/products")
public class ProductController {

    @Autowired
    private ProductServices service;
    
    @GetMapping
    public ResponseEntity<List<Product>> productList() {
        return ResponseEntity.ok().body(service.findAll());
    }
    
    @GetMapping("/{id}")
    public ResponseEntity<Product> findProductById(@PathVariable Long id) {
        return ResponseEntity.ok().body(service.findById(id));
    }

    @PostMapping
    public ResponseEntity<Product> insertProduct(@RequestBody Product product) {
        return ResponseEntity.ok().body(service.insert(product));
    }

    @PutMapping
    public ResponseEntity<Product> editProduct(@RequestBody Product product) {
        return ResponseEntity.ok().body(service.insert(product));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Product> deleteProduct(@PathVariable Long id) {
        service.delete(id);
        return ResponseEntity.noContent().build();
    }
}
