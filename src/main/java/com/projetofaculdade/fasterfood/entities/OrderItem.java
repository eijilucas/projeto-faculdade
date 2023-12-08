
package com.projetofaculdade.fasterfood.entities;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.projetofaculdade.fasterfood.entities.pk.OrderItemPK;

import jakarta.persistence.EmbeddedId;
import jakarta.persistence.Entity;
import jakarta.persistence.Table;

@Entity
@Table(name ="orderItens")
public class OrderItem {
    
	@EmbeddedId
	private OrderItemPK id = new OrderItemPK();
	
    private int quantity;
    private double price;

    public OrderItem() {
    	
    }
    
    public OrderItem(Order order, Product product, int quantity, double price) {
		super();
		id.setOrder(order);
		id.setProduct(product);
		this.quantity = quantity;
		this.price = price;
	}

    @JsonIgnore
	public Order getOrder() {
		return id.getOrder();
	}
	
	public void setOrder(Order order) {
		id.setOrder(order);
	}
	
	public Product getProduct() {
		return id.getProduct();
	}
	
	public void setProduct(Product product) {
		id.setProduct(product);
	}
    
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
    	return price * quantity;
    }
}
