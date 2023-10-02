
package com.projetofaculdade.fasterfood.entities;

import jakarta.persistence.Entity;

public class OrderItem {
    
    private int quantity;
    private double price;

    public int getQuantity() {
        return quantity;
    }

    public void setQuantity(int quantity) {
        this.quantity = quantity;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }
    
    public double subTotal(){
        
        // Finalizar método
        return 0;
    }
}
