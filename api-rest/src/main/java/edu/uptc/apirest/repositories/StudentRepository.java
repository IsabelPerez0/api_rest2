package edu.uptc.apirest.repositories;


import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import edu.uptc.apirest.entities.Student;

@Repository
public interface StudentRepository  extends JpaRepository<Student, Integer>{
    
}
