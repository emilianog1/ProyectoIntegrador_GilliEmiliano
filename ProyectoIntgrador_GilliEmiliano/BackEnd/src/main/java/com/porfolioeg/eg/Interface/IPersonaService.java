package com.porfolioeg.eg.Interface;

import com.porfolioeg.eg.Entity.Persona;
import java.util.List;


/**
 * @author Emiliano
 */
public interface IPersonaService {
    //traer una lista de personas
    public List<Persona> getPersona();
    
    //guardar un objeto del tipo persona
    public void savePersona(Persona persona);
    
    //eliminar un objeto pero lo buscamos por id
    public void deletePersona(Long id);
    
    //buscar una persona por id
    public Persona findPersona(Long id);
}
