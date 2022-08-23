/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.portfoliweb.mauricio.Security.Service;

import com.portfoliweb.mauricio.Security.Entity.Rol;
import com.portfoliweb.mauricio.Security.Enums.RolNombre;
import com.portfoliweb.mauricio.Security.Repository.iRolRepository;
import java.util.Optional;
import javax.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
@Transactional
public class RolService {
@Autowired 
        iRolRepository irolRepository;
public Optional<Rol> getByRolNombre(RolNombre rolNombre){
return irolRepository.findByRolNombre(rolNombre);
}
public void saveRol(Rol rol){
irolRepository.save(rol);
}

}