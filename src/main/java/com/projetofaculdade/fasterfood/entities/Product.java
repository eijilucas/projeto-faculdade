
package com.projetofaculdade.fasterfood.entities;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;

@Entity
@Table(name = "products")
public class Product {
    
    @Id
    @Column(name = "product_id")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long productId;
    
    @ManyToOne
    @JoinColumn(name = "collaborator_id")
    private Collaborator collaboratorId;
    
    @ManyToOne
    @JoinColumn(name = "stock_id")
    private Stock stockId;
    
    private String name;
    private double price;
    private String image;
    private String description;

    public Long getProductId() {
        return productId;
    }

    public void setProductId(Long productId) {
        this.productId = productId;
    }
    
    public Collaborator getCollaboratorId() {
        return collaboratorId;
    }

    public void setCollaboratorId(Collaborator collaboratorId) {
        this.collaboratorId = collaboratorId;
    }

    public Stock getStockId() {
        return stockId;
    }

    public void setStockId(Stock stockId) {
        this.stockId = stockId;
    }
    
    
    
    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    public String getImage() {
        return image;
    }

    public void setImage(String image) {
        this.image = image;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }
    
    
}
