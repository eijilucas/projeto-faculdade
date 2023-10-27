
package com.projetofaculdade.fasterfood.entities;

import com.projetofaculdade.fasterfood.entities.enums.UserAccess;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;

@Entity
public class Collaborator {
    
    @Id
    @Column(name = "collaborator_id")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    
    private String email;
    private String password;
    
    private UserAccess userAccess;
}
