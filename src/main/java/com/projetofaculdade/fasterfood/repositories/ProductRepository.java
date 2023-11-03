
package com.projetofaculdade.fasterfood.repositories;

import com.projetofaculdade.fasterfood.entities.Product;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ProductRepository extends JpaRepository<Product, Long>{
    
}
