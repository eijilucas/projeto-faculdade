
package com.projetofaculdade.fasterfood.controllers.services;

import com.projetofaculdade.fasterfood.controllers.services.exceptions.DatabaseException;
import com.projetofaculdade.fasterfood.controllers.services.exceptions.ResourceNotFoundException;
import com.projetofaculdade.fasterfood.entities.Costumer;
import com.projetofaculdade.fasterfood.repositories.CostumerRepository;
import jakarta.persistence.EntityNotFoundException;
import java.util.List;
import java.util.Optional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.stereotype.Service;

@Service
public class CostumerServices {
    
    @Autowired
    private CostumerRepository costumerRepository;
    
    public Costumer insert(Costumer Costumer) {
        return costumerRepository.save(Costumer);
    }

    public Costumer update(Costumer Costumer, Long id) {
        try {
            Costumer entity = costumerRepository.getReferenceById(id);
            updateData(entity, Costumer);
            return costumerRepository.save(entity);
        } catch (EntityNotFoundException ex) {
            throw new ResourceNotFoundException(id);
        }
    }

    public void updateData(Costumer entity, Costumer costumer) {
        entity.setName(costumer.getName());
    }
    
    public void delete (Long id) {
        try {
            costumerRepository.deleteById(id);
        } catch (EmptyResultDataAccessException ex) {
            throw new ResourceNotFoundException(id);
        } catch (DataIntegrityViolationException ex) {
            throw new DatabaseException(ex.getMessage());
        }
    }

    public List<Costumer> findAll() {
        return costumerRepository.findAll();
    }

    public Costumer findById(Long id) {
        Optional<Costumer> costumer = costumerRepository.findById(id);
        return costumer.get();
    }
}
