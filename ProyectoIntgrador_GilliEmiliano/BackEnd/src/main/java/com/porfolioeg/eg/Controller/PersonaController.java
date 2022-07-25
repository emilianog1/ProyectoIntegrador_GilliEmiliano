package com.porfolioeg.eg.Controller;

import com.porfolioeg.eg.Entity.Persona;
import com.porfolioeg.eg.Interface.IPersonaService;
import com.porfolioeg.eg.Security.Controller.Mensaje;
import com.porfolioeg.eg.Service.ImpPersonaService;
import java.util.List;
import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

/**
 *
 * @author Emiliano
 */
@RestController
@RequestMapping("/personas")
@CrossOrigin(origins = "http://localhost:4200/")
public class PersonaController {
    
    @Autowired IPersonaService iPersonaService;
    
    @GetMapping("/traer/{id}")
    public List<Persona> findPersona(@PathVariable("id") int id){
        return iPersonaService.getPersona();
    }
    
    @PreAuthorize("hasRole('ADMIN')")
    @PostMapping("/crear")
    public String crearPersona(@RequestBody Persona persona){
        iPersonaService.savePersona(persona);
        return "La persona fue creada correctamente";
    }
    
    @PreAuthorize("hasRole('ADMIN')")
    @DeleteMapping("/borrar/{id}")
    public String deletePersona(@PathVariable Long id){
        iPersonaService.deletePersona(id);
        return "La persona fue eliminada correctamente";
    }
    
    //URL de ejemplo: PUERTO/personas/editar/4/nombre & apellido & img
    /*
    @PreAuthorize("hasRole('ADMIN')")
    @PutMapping("/personas/editar/{id}")
    public Persona editPersona(@PathVariable Long id,
                                @RequestParam("nombre") String nuevoNombre,
                                @RequestParam("apellido") String nuevoApellido,
                                @RequestParam("descripcion") String nuevaDescripcion,
                                @RequestParam("titulo") String nuevoTitulo,
                                @RequestParam("img") String nuevoImg){
        Persona persona = iPersonaService.findPersona(id);
        
        persona.setNombre(nuevoNombre);
        persona.setApellido(nuevoApellido);
        persona.setDescripcion(nuevaDescripcion);
        persona.setTitulo(nuevoTitulo);
        persona.setImg(nuevoImg);
        
        iPersonaService.savePersona(persona);
        return persona;
    }
    */
    
    @PreAuthorize("hasRole('ADMIN')")
    @PutMapping("editar/{id}")
    public ResponseEntity<?> update(@PathVariable("id") Long id, @RequestBody Persona dtoper){
        //Validamos si existe el ID
        if(!iPersonaService.existsById(id))
            return new ResponseEntity(new Mensaje("El ID no existe"), HttpStatus.BAD_REQUEST);
        
        Persona persona = iPersonaService.getOne(id).get();
        persona.setNombre(dtoper.getNombre());
        persona.setApellido(dtoper.getApellido());
        persona.setDescripcion(dtoper.getDescripcion());
        persona.setTitulo(dtoper.getTitulo());
        persona.setImg(dtoper.getImg());
                
        iPersonaService.savePersona(persona);
        return new ResponseEntity(new Mensaje("Perfil actualizado"), HttpStatus.OK);
             
    }
    
    @GetMapping("/traer/perfil")
    public Persona findPersona(){
        return iPersonaService.findPersona((long)1);
    }

}
