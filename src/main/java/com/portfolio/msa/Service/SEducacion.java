
package com.portfolio.msa.Service;

import com.portfolio.msa.Entity.Educacion;
import com.portfolio.msa.Repository.REducacion;
import java.util.List;
import java.util.Optional;
import javax.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;


@Service
@Transactional
public class SEducacion {
    @Autowired
    REducacion rEducacion;
    
    public List<Educacion>list(){
        return rEducacion.findAll();
    }
    
    
    public Optional<Educacion> getOne(int id){
        return rEducacion.findById(id);
    }
    
    
    public Optional<Educacion> getByTituloE(String tituloE ){
        return rEducacion.findByTituloE(tituloE);
    }
    
    public void save(Educacion educacion){
        rEducacion.save(educacion);
    }
    
    public void delete(int id){
        rEducacion.deleteById(id);
    }
    
    public boolean existsById(int id){
        return rEducacion.existsById(id);
    }
    
    public boolean existsByTituloE(String tituloE){
        return rEducacion.existsByTituloE(tituloE);
    }
    
}
