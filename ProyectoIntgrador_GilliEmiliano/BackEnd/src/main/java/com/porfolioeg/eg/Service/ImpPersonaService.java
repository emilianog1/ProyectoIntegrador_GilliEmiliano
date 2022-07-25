package com.porfolioeg.eg.Service;

import com.porfolioeg.eg.Entity.Persona;
import com.porfolioeg.eg.Interface.IPersonaService;
import com.porfolioeg.eg.Repository.IPersonaRepository;
import java.util.List;
import java.util.Optional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 *
 * @author Emiliano
 */
@Service
public class ImpPersonaService implements IPersonaService {
    
    @Autowired IPersonaRepository ipersonaRepository;
    
    @Override
    public List<Persona> getPersona() {
        List<Persona> persona = ipersonaRepository.findAll();
        return persona;
    }
    
    public List<Persona> list(){
         return ipersonaRepository.findAll();
     }

    public Optional<Persona> getOne(Long id){
         return ipersonaRepository.findById(id);
     }
    
    @Override
    public void savePersona(Persona persona) {
        ipersonaRepository.save(persona);
    }
    
    @Override
    public void deletePersona(Long id) {
        ipersonaRepository.deleteById(id);
    }

    @Override
    public Persona findPersona(Long id) {
        Persona persona = ipersonaRepository.findById(id).orElse(null);
        return persona;
    }
 
    @Override
    public boolean existsById(Long id){
         return ipersonaRepository.existsById(id);
     }
}
