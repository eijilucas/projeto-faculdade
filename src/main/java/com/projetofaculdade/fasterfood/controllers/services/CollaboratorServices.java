package com.projetofaculdade.fasterfood.controllers.services;

import com.projetofaculdade.fasterfood.controllers.services.exceptions.DatabaseException;
import com.projetofaculdade.fasterfood.controllers.services.exceptions.ResourceNotFoundException;
import com.projetofaculdade.fasterfood.entities.Collaborator;
import com.projetofaculdade.fasterfood.repositories.CollaboratorRepository;
import jakarta.persistence.EntityNotFoundException;
import java.util.List;
import java.util.Optional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.stereotype.Service;

@Service
public class CollaboratorServices {

    @Autowired
    private CollaboratorRepository collaboratorRepository;

    public Collaborator insert(Collaborator collaborator) {
        return collaboratorRepository.save(collaborator);
    }

    public Collaborator update(Collaborator collaborator, Long id) {
        try {
            Collaborator entity = collaboratorRepository.getReferenceById(id);
            updateData(entity, collaborator);
            return collaboratorRepository.save(entity);
        } catch (EntityNotFoundException ex) {
            throw new ResourceNotFoundException(id);
        }
    }

    public void updateData(Collaborator entity, Collaborator collaborator) {
        entity.setEmail(collaborator.getEmail());
        entity.setPassword(collaborator.getPassword());
        entity.setUserAccess(collaborator.getUserAccess());
    }
    
    public void delete (Long id) {
        try {
            collaboratorRepository.deleteById(id);
        } catch (EmptyResultDataAccessException ex) {
            throw new ResourceNotFoundException(id);
        } catch (DataIntegrityViolationException ex) {
            throw new DatabaseException(ex.getMessage());
        }
    }

    public List<Collaborator> findAll() {
        return collaboratorRepository.findAll();
    }

    public Collaborator findById(Long id) {
        Optional<Collaborator> collaborator = collaboratorRepository.findById(id);
        return collaborator.get();
    }
}
