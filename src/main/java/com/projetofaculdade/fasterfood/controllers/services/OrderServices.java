
package com.projetofaculdade.fasterfood.controllers.services;

import com.projetofaculdade.fasterfood.controllers.services.exceptions.DatabaseException;
import com.projetofaculdade.fasterfood.controllers.services.exceptions.ResourceNotFoundException;
import com.projetofaculdade.fasterfood.entities.Order;
import com.projetofaculdade.fasterfood.repositories.OrderRepository;
import jakarta.persistence.EntityNotFoundException;
import java.util.List;
import java.util.Optional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.stereotype.Service;

@Service
public class OrderServices {
    
    @Autowired
    private OrderRepository orderRepository;
    
    public Order insert(Order order) {
        return orderRepository.save(order);
    }

    public Order update(Order order, Long id) {
        try {
            Order entity = orderRepository.getReferenceById(id);
            updateData(entity, order);
            return orderRepository.save(entity);
        } catch (EntityNotFoundException ex) {
            throw new ResourceNotFoundException(id);
        }
    }

    public void updateData(Order entity, Order order) {
        entity.setCostumerName(order.getCostumerName());
        entity.setDataHora(order.getDataHora());
        entity.setOrderStatus(order.getOrderStatus());
    }
    
    public void delete (Long id) {
        try {
            orderRepository.deleteById(id);
        } catch (EmptyResultDataAccessException ex) {
            throw new ResourceNotFoundException(id);
        } catch (DataIntegrityViolationException ex) {
            throw new DatabaseException(ex.getMessage());
        }
    }

    public List<Order> findAll() {
        return orderRepository.findAll();
    }

    public Order findById(Long id) {
        Optional<Order> order = orderRepository.findById(id);
        return order.get();
    }
}
