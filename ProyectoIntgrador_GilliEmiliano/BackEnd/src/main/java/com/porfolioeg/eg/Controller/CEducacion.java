package com.porfolioeg.eg.Controller;

import com.porfolioeg.eg.Dto.dtoEducacion;
import com.porfolioeg.eg.Entity.Educacion;
import com.porfolioeg.eg.Security.Controller.Mensaje;
import com.porfolioeg.eg.Service.SEducacion;
import java.util.List;
import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 *
 * @author Emiliano
 */
@RestController
@RequestMapping("/edu")
@CrossOrigin(origins = "http://localhost:4200")
public class CEducacion {
    @Autowired
    SEducacion sEducacion;
    
    @GetMapping("/lista")
    public ResponseEntity<List<Educacion>> list(){//busco las educaciones
        List<Educacion> list = sEducacion.list();
        return new ResponseEntity(list, HttpStatus.OK);
    }
    
    @GetMapping("/detail/{id}")
    public ResponseEntity<Educacion> getById(@PathVariable("id") int id){
        if(!sEducacion.existsById(id))//reviso que exista la educacion por ID
            return new ResponseEntity(new Mensaje("no existe"), HttpStatus.NOT_FOUND);
        Educacion educacion = sEducacion.getOne(id).get();//si existe la muestro
        return new ResponseEntity(educacion, HttpStatus.OK);
    }
    
    @DeleteMapping("/delete/{id}")
    public ResponseEntity<?> delete(@PathVariable("id") int id) {
        if (!sEducacion.existsById(id)) {//reviso que exista la educacion
            return new ResponseEntity(new Mensaje("no existe"), HttpStatus.NOT_FOUND);
        }
        sEducacion.delete(id); //si existe la elimino
        return new ResponseEntity(new Mensaje("producto eliminado"), HttpStatus.OK);
    }

    
    @PostMapping("/create")
    public ResponseEntity<?> create(@RequestBody dtoEducacion dtoedu){      
        if(StringUtils.isBlank(dtoedu.getNombreEd())) //me fijo si no escribio nada
            return new ResponseEntity(new Mensaje("El nombre es obligatorio"), HttpStatus.BAD_REQUEST);
        if(sEducacion.existsByNombreEd(dtoedu.getNombreEd())) //me fijo si ya existe
            return new ResponseEntity(new Mensaje("Esa experiencia existe"), HttpStatus.BAD_REQUEST);
        //creo la educacion con los datos ingresados
        Educacion educacion = new Educacion(dtoedu.getNombreEd(), dtoedu.getDescripcionEd(),dtoedu.getEstadoEd());
        sEducacion.save(educacion); //guardo lo que se cargo en la linea de arriba
        
        return new ResponseEntity(new Mensaje("Educacion agregada"), HttpStatus.OK);
    }
    
    @PutMapping("/update/{id}")
    public ResponseEntity<?> update(@PathVariable("id") int id, @RequestBody dtoEducacion dtoedu){//actualizo la educacion
        //reviso que exista la educacion
        if(!sEducacion.existsById(id))
            return new ResponseEntity(new Mensaje("El ID no existe"), HttpStatus.BAD_REQUEST);
        //Compara nombre de educacion
        if(sEducacion.existsByNombreEd(dtoedu.getNombreEd()) && sEducacion.getByNombreEd(dtoedu.getNombreEd()).get().getId() != id)
            return new ResponseEntity(new Mensaje("Esa educacion ya existe"), HttpStatus.BAD_REQUEST);
        //El nombre no puede estar vacio
        if(StringUtils.isBlank(dtoedu.getNombreEd()))
            return new ResponseEntity(new Mensaje("El nombre es obligatorio"), HttpStatus.BAD_REQUEST);
        //si pasa todas las condiciones actualizo la educacion
        Educacion educacion = sEducacion.getOne(id).get();
        educacion.setNombreEd(dtoedu.getNombreEd());
        educacion.setDescripcionEd((dtoedu.getDescripcionEd()));
        educacion.setEstadoEd(dtoedu.getEstadoEd());
        
        sEducacion.save(educacion);
        return new ResponseEntity(new Mensaje("Educacion actualizada"), HttpStatus.OK);
             
    }
}
