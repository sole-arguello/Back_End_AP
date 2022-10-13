
package com.portfolio.msa.Repository;

import com.portfolio.msa.Entity.Skills;
import java.util.Optional;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface RSkills extends JpaRepository<Skills,Integer>{
    public Optional<Skills>findByNombreS(String nombreS);
    public boolean existsByNombreS(String nombreS);
    
}
