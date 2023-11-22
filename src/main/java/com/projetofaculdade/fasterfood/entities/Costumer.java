
package com.projetofaculdade.fasterfood.entities;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Entity
@Table(name = "costumers")
public class Costumer {
    
    @Id
    @Column(name = "costumer_id")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long costumerId;
    
    @Column(name = "costumer_name")
    private String Name;

    public Long getCostumerId() {
        return costumerId;
    }

    public void setCostumerId(Long costumerId) {
        this.costumerId = costumerId;
    }

    public String getName() {
        return Name;
    }

    public void setName(String Name) {
        this.Name = Name;
    }
}
