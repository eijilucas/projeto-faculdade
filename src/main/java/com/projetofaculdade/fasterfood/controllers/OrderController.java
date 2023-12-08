
package com.projetofaculdade.fasterfood.controllers;

import com.projetofaculdade.fasterfood.controllers.services.OrderServices;
import com.projetofaculdade.fasterfood.entities.Order;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@CrossOrigin("*")
@RequestMapping("/orders")
public class OrderController {

    @Autowired
    private OrderServices service;
    
    @GetMapping
    public ResponseEntity<List<Order>> orderList() {
        return ResponseEntity.ok().body(service.findAll());
    }
    
    @GetMapping("/{id}")
    public ResponseEntity<Order> findOrderById(@PathVariable Long id) {
        return ResponseEntity.ok().body(service.findById(id));
    }

    @PostMapping
    public ResponseEntity<Order> insertOrder(@RequestBody Order order) {
        return ResponseEntity.ok().body(service.insert(order));
    }

    @PutMapping
    public ResponseEntity<Order> editOrder(@RequestBody Order order) {
        return ResponseEntity.ok().body(service.insert(order));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Order> deleteOrder(@PathVariable Long id) {
        service.delete(id);
        return ResponseEntity.noContent().build();
    }
}
