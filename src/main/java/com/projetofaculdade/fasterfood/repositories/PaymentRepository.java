
package com.projetofaculdade.fasterfood.repositories;

import com.projetofaculdade.fasterfood.entities.Payment;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface PaymentRepository extends JpaRepository<Payment, Long>{
    
}
