
package com.projetofaculdade.fasterfood.entities;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import java.util.Calendar;

@Entity
public class Stock {
    
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long productId;
    
    private int quantity;
    private Calendar expirationDate;

    public Long getProductId() {
        return productId;
    }

    public void setProductId(Long productId) {
        this.productId = productId;
    }

    public int getQuantity() {
        return quantity;
    }

    public void setQuantity(int quantity) {
        this.quantity = quantity;
    }

    public Calendar getExpirationDate() {
        return expirationDate;
    }

    public void setExpirationDate(Calendar expirationDate) {
        this.expirationDate = expirationDate;
    }
    
    
}
