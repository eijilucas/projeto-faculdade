
package com.projetofaculdade.fasterfood.entities;

import com.projetofaculdade.fasterfood.entities.enums.UserAccess;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Entity
@Table(name = "collaborators")
public class Collaborator {
    
    @Id
    @Column(name = "collaborator_id")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    
    private String email;
    private String password;
    private UserAccess userAccess;
    
    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public UserAccess getUserAccess() {
        return userAccess;
    }

    public void setUserAccess(UserAccess userAccess) {
        this.userAccess = userAccess;
    }
    
}
