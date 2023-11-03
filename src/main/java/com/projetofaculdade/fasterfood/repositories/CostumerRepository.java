
package com.projetofaculdade.fasterfood.repositories;

import com.projetofaculdade.fasterfood.entities.Costumer;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface CostumerRepository extends JpaRepository<Costumer, Long>{
    
}
