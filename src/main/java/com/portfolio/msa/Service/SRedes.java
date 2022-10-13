
package com.portfolio.msa.Service;

import com.portfolio.msa.Entity.Redes;
import com.portfolio.msa.Repository.RRedes;
import java.util.List;
import java.util.Optional;
import javax.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
@Transactional
public class SRedes {
    @Autowired
    RRedes rRedes;
    
    public List<Redes>list(){
        return rRedes.findAll();
    }
    public Optional<Redes> getOne(int id){
        return rRedes.findById(id);
    }
    public void save(Redes redes){
        rRedes.save(redes);
    }
    public void delete(int id){
        rRedes.deleteById(id);
    }
    public boolean existsById(int id){
        return rRedes.existsById(id);
    }
}
