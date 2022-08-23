
package com.portfoliweb.mauricio.Repository;

import com.portfoliweb.mauricio.Entity.Persona;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface IPersonaRepository extends JpaRepository<Persona,Long > {
    
}
