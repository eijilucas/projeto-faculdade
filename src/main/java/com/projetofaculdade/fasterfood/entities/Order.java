
package com.projetofaculdade.fasterfood.entities;

import com.projetofaculdade.fasterfood.entities.enums.OrderStatus;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;
import java.util.Calendar;
import java.util.List;

@Entity
@Table(name = "orders")
public class Order {
    
    @Id
    @Column(name = "order_id")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long orderId;
    
    @ManyToOne
    @JoinColumn(name = "costumer_id")
    private Costumer costumerId;
    
    private Calendar registrationTime;
    private List<OrderStatus> orderStatus;

    public Long getOrderId() {
        return orderId;
    }

    public void setOrderId(Long orderId) {
        this.orderId = orderId;
    }

    public Costumer getCostumerName() {
        return costumerId;
    }

    public void setCostumerName(Costumer costumerId) {
        this.costumerId = costumerId;
    }

    public Calendar getRegistrationTime() {
        return registrationTime;
    }

    public void setRegistrationTime(Calendar registrationTime) {
        this.registrationTime = registrationTime;
    }

    public List<OrderStatus> getOrderStatus() {
        return orderStatus;
    }

    public void setOrderStatus(List<OrderStatus> orderStatus) {
        this.orderStatus = orderStatus;
    }
    
    
    public double total(){
        
        // TODO Finalizar método
        return 0;
    }
}
