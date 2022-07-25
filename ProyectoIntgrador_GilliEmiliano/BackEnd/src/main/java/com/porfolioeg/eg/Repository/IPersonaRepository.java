package com.porfolioeg.eg.Repository;

import com.porfolioeg.eg.Entity.Persona;
import java.util.Optional;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

/**
 * @author Emiliano
 */
@Repository
public interface IPersonaRepository extends JpaRepository<Persona,Long>{

}
