package com.portfoliweb.mauricio.Security.Repository;

import com.portfoliweb.mauricio.Security.Entity.Rol;
import com.portfoliweb.mauricio.Security.Enums.RolNombre;
import java.util.Optional;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface iRolRepository extends JpaRepository<Rol, Integer>{
    Optional<Rol> findByRolNombre (RolNombre rolNombre);
    
    
}

