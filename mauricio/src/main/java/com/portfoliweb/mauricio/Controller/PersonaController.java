package com.portfoliweb.mauricio.Controller;

import com.portfoliweb.mauricio.Entity.Persona;
import com.portfoliweb.mauricio.Interface.IPersonaService;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
@CrossOrigin(origins = "http://localhost:4200")

public class PersonaController {

    @Autowired
    IPersonaService ipersonaService;

    @GetMapping("personas/traer")
    public List<Persona> getPersona() {
        return ipersonaService.getPersona();
    }

    @GetMapping("personas/traer/perfil")
    public Persona findPersona() {
        return ipersonaService.findPersona((long) 1);
    }

    @PreAuthorize("hasRole('ADMIN')")
    @PostMapping("/personas/crear")
    public String createPersona(@RequestBody Persona persona) {
        ipersonaService.savePersona(persona);
        return "La persona fue creada correctamente";
    }

    @PreAuthorize("hasRole('ADMIN')")
    @DeleteMapping("personas/borrar/{id}")
    public String deletePersona(@PathVariable Long id) {
        ipersonaService.deletePersona(id);
        return "La persona fue borrada correctamente";
    }

    @PreAuthorize("hasRole('ADMIN')")
    @PutMapping("personas/editar/{id}")
    public Persona editPersona(@PathVariable Long id,
            @RequestParam("nombre") String nuevoNombre,
            @RequestParam("apellido") String nuevoApellido,
            @RequestParam("img") String nuevaImg,
            @RequestParam("descripcion") String nuevaDescripcion,
            @RequestParam("titulo") String NuevoTitulo) {
        Persona persona = ipersonaService.findPersona(id);

        persona.setNombre(nuevoNombre);
        persona.setApellido(nuevoApellido);
        persona.setImg(nuevaImg);
        persona.setDescripcion(nuevaDescripcion);
        persona.setTitulo(NuevoTitulo);

        ipersonaService.savePersona(persona);

        return persona;
    }
}
