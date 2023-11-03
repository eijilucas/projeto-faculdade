
package com.projetofaculdade.fasterfood.repositories;

import com.projetofaculdade.fasterfood.entities.Order;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface OrderRepository extends JpaRepository<Order, Long>{
    
}
