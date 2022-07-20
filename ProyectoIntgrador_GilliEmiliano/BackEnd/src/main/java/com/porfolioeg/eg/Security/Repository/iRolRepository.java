package com.porfolioeg.eg.Security.Repository;

import com.porfolioeg.eg.Security.Entity.Rol;
import com.porfolioeg.eg.Security.Enums.RolNombre;
import java.util.Optional;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

/**
 *
 * @author Emiliano
 */
@Repository 
public interface iRolRepository extends JpaRepository<Rol, Integer>{
    Optional<Rol> findByRolNombre(RolNombre rolNombre);
}
