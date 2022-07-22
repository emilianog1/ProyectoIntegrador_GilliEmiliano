package com.porfolioeg.eg.Repository;

import com.porfolioeg.eg.Entity.Skill;
import java.util.Optional;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

/**
 *
 * @author Emiliano
 */
@Repository
public interface RSkill extends JpaRepository<Skill, Integer>{
    public Optional<Skill> findByNombreS(String nombreS);
    public boolean existsByNombreS(String nombreS);
}
