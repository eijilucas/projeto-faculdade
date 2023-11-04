
package com.projetofaculdade.fasterfood.entities;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.OneToOne;
import java.util.Calendar;

@Entity
public class Payment {
    
    @Id
    @Column(name = "payment_id")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    
    @OneToOne
    @JoinColumn(name = "order_id")
    private Order orderId;
     
    private Long costumerId;
    private Calendar registrationTime;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Long getCostumerId() {
        return costumerId;
    }

    public void setCostumerId(Long costumerId) {
        this.costumerId = costumerId;
    }

    public Order getOrderId() {
        return orderId;
    }

    public void setOrderId(Order orderId) {
        this.orderId = orderId;
    }

    public Calendar getRegistrationTime() {
        return registrationTime;
    }

    public void setRegistrationTime(Calendar registrationTime) {
        this.registrationTime = registrationTime;
    }
}
