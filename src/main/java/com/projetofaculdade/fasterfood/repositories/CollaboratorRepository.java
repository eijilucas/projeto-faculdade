
package com.projetofaculdade.fasterfood.repositories;

import com.projetofaculdade.fasterfood.entities.Collaborator;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface CollaboratorRepository extends JpaRepository<Collaborator, Long>{

}
