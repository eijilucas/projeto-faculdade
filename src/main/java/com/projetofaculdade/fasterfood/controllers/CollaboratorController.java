package com.projetofaculdade.fasterfood.controllers;

import com.projetofaculdade.fasterfood.controllers.services.CollaboratorServices;
import com.projetofaculdade.fasterfood.entities.Collaborator;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@CrossOrigin("*")
@RequestMapping("/collaborators")
public class CollaboratorController {

    @Autowired
    private CollaboratorServices service;

    @GetMapping
    public ResponseEntity<List<Collaborator>> collaboratorList() {
        return ResponseEntity.ok().body(service.findAll());
    }
    
    @GetMapping("/{id}")
    public ResponseEntity<Collaborator> findCollaboratorById(@PathVariable Long id) {
        return ResponseEntity.ok().body(service.findById(id));
    }

    @PostMapping
    public ResponseEntity<Collaborator> insertCollaborator(@RequestBody Collaborator collaborator) {
        return ResponseEntity.ok().body(service.insert(collaborator));
    }

    @PutMapping
    public ResponseEntity<Collaborator> editCollaborator(@RequestBody Collaborator collaborator) {
        return ResponseEntity.ok().body(service.insert(collaborator));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Collaborator> deleteCollaborator(@PathVariable Long id) {
        service.delete(id);
        return ResponseEntity.noContent().build();
    }
}
