
package com.projetofaculdade.fasterfood.repositories;

import com.projetofaculdade.fasterfood.entities.OrderItem;
import org.springframework.data.jpa.repository.JpaRepository;


public interface OrderItemRepository extends JpaRepository<OrderItem, Long>{
    
}
