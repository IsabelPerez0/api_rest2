package edu.uptc.apirest.repositories;


import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import edu.uptc.apirest.entities.Matter;

@Repository
public interface MatterRepository  extends JpaRepository<Matter, String>{
    
}
