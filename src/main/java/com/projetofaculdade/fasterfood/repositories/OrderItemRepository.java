package com.projetofaculdade.fasterfood.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.projetofaculdade.fasterfood.entities.OrderItem;

@Repository
public interface OrderItemRepository extends JpaRepository<OrderItem, Long>{

}
