
package com.projetofaculdade.fasterfood.controllers.services;

import com.projetofaculdade.fasterfood.controllers.services.exceptions.DatabaseException;
import com.projetofaculdade.fasterfood.controllers.services.exceptions.ResourceNotFoundException;
import com.projetofaculdade.fasterfood.entities.Product;
import com.projetofaculdade.fasterfood.repositories.ProductRepository;
import jakarta.persistence.EntityNotFoundException;
import java.util.List;
import java.util.Optional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.stereotype.Service;

@Service
public class ProductServices {

    @Autowired
    private ProductRepository productRepository;
    
    public Product insert(Product product) {
        return productRepository.save(product);
    }

    public Product update(Product product, Long id) {
        try {
            Product entity = productRepository.getReferenceById(id);
            updateData(entity, product);
            return productRepository.save(entity);
        } catch (EntityNotFoundException ex) {
            throw new ResourceNotFoundException(id);
        }
    }

    public void updateData(Product entity, Product product) {
        entity.setName(product.getName());
        entity.setPrice(product.getPrice());
        entity.setImage(product.getImage());
        entity.setDescription(product.getDescription());
    }
    
    public void delete (Long id) {
        try {
            productRepository.deleteById(id);
        } catch (EmptyResultDataAccessException ex) {
            throw new ResourceNotFoundException(id);
        } catch (DataIntegrityViolationException ex) {
            throw new DatabaseException(ex.getMessage());
        }
    }

    public List<Product> findAll() {
        return productRepository.findAll();
    }

    public Product findById(Long id) {
        Optional<Product> product = productRepository.findById(id);
        return product.get();
    }
}
