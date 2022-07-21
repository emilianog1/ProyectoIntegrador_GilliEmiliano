package com.porfolioeg.eg.Repository;

import com.porfolioeg.eg.Entity.Educacion;
import java.util.Optional;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

/**
 *
 * @author Emiliano
 */
@Repository
public interface REducacion extends JpaRepository<Educacion, Integer>{
    public Optional<Educacion> findByNombreEd(String nombreEd);
    public boolean existsByNombreEd(String nombreEd);
}
