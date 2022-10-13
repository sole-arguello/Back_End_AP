
package com.portfolio.msa.Repository;

import com.portfolio.msa.Entity.Redes;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface RRedes extends JpaRepository<Redes,Integer>{
    
    
}
