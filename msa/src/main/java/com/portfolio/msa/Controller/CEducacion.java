
package com.portfolio.msa.Controller;

import com.portfolio.msa.Dto.dtoEducacion;
import com.portfolio.msa.Entity.Educacion;
import com.portfolio.msa.Security.Controller.Mensaje;
import com.portfolio.msa.Service.SEducacion;
import java.util.List;
import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;

import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("edu")
@CrossOrigin(origins="http://localhost:4200")
public class CEducacion {
    @Autowired
    SEducacion sEducacion;
    
    @GetMapping("/lista")
    public ResponseEntity<List<Educacion>> list(){
        List<Educacion> list=sEducacion.list();
        return new ResponseEntity(list,HttpStatus.OK);
    }
    @GetMapping("/detail/{id}")
    public ResponseEntity<Educacion>getById(@PathVariable("id") int id){
        if(!sEducacion.existsById(id))
            return new ResponseEntity(new Mensaje("No existe"), HttpStatus.NOT_FOUND);
        Educacion educacion=sEducacion.getOne(id).get();
        return new ResponseEntity(educacion,HttpStatus.OK);
        
    }
    @DeleteMapping("/delete/{id}")
    public ResponseEntity<?> delete(@PathVariable("id") int id){
        if(!sEducacion.existsById(id)){
            return new ResponseEntity(new Mensaje("no existe"), HttpStatus.NOT_FOUND);
        }
        sEducacion.delete(id);
        return new ResponseEntity(new Mensaje("Educacion Eliminada"),HttpStatus.OK);
    }
    
    @PostMapping("/create")
    public ResponseEntity<?> create(@RequestBody dtoEducacion dtoedu){
        if(StringUtils.isBlank(dtoedu.getTituloE())){
            return new ResponseEntity(new Mensaje("El nombre de la Titulo es obligatorio"), HttpStatus.BAD_REQUEST);
        }
        if(sEducacion.existsByTituloE(dtoedu.getTituloE())){
            return new ResponseEntity(new Mensaje("Ya incorporo ese titulo obtenido"), HttpStatus.BAD_REQUEST);
            
        }
            
        Educacion educacion=new Educacion(dtoedu.getImgE(),dtoedu.getInstitucionE(),dtoedu.getTituloE(),dtoedu.getAnioE(),dtoedu.getCondicionE());
        sEducacion.save(educacion);
        return new ResponseEntity(new Mensaje("Educacion agregada"), HttpStatus.OK);
        
    }
    
    @PutMapping("/update/{id}")
    public ResponseEntity<?> update(@PathVariable("id") int id, @RequestBody  dtoEducacion dtoedu){
        if(!sEducacion.existsById(id)){
            return new ResponseEntity(new Mensaje("El ID no existe"),HttpStatus.BAD_REQUEST);
        }
        if(sEducacion.existsByTituloE(dtoedu.getTituloE()) && sEducacion.getByTituloE(dtoedu.getTituloE()).get().getId() !=id){
            return new ResponseEntity(new Mensaje("Esa Educacion Ya existe"), HttpStatus.BAD_REQUEST);
        }
        if(StringUtils.isBlank(dtoedu.getTituloE())){
            return new ResponseEntity(new Mensaje("el Titulo es obligatorio"), HttpStatus.BAD_REQUEST);
        }
        Educacion educacion= sEducacion.getOne(id).get();
        educacion.setImgE(dtoedu.getImgE());
        educacion.setTituloE(dtoedu.getTituloE());
        educacion.setAnioE(dtoedu.getAnioE());
        educacion.setInstitucionE(dtoedu.getInstitucionE());
        educacion.setCondicionE(dtoedu.getCondicionE());
        sEducacion.save(educacion);
        return new ResponseEntity(new Mensaje("Educacion actualizada"), HttpStatus.OK);
        
    }
}
