
package com.portfolio.msa.Controller;

import com.portfolio.msa.Dto.dtoSkills;
import com.portfolio.msa.Entity.Skills;
import com.portfolio.msa.Security.Controller.Mensaje;
import com.portfolio.msa.Service.SSkills;
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
@RequestMapping("ski")
//@CrossOrigin(origins="http://localhost:4200")
@CrossOrigin(origins="https://front-end-msa.web.app/")
public class CSkills {
    @Autowired
    SSkills sSkills;
    
    
    @GetMapping("/lista")
    public ResponseEntity<List<Skills>> list(){
        List<Skills> list=sSkills.list();
        return new ResponseEntity(list,HttpStatus.OK);
        
    }
    @GetMapping("/detail/{id}")
    public ResponseEntity<Skills>getById(@PathVariable("id") int id){
        if(!sSkills.existsById(id))
            return new ResponseEntity(new Mensaje("No existe"), HttpStatus.NOT_FOUND);
        Skills skills = sSkills.getOne(id).get();
        return new ResponseEntity(skills,HttpStatus.OK);
        
    }
    @DeleteMapping("/delete/{id}")
    public ResponseEntity<?> delete(@PathVariable("id") int id){
        if(!sSkills.existsById(id)){
            return new ResponseEntity(new Mensaje("no existe"), HttpStatus.NOT_FOUND);
        }
        sSkills.delete(id);
        return new ResponseEntity(new Mensaje("Skills Eliminada"), HttpStatus.OK);
    }
    @PostMapping("/create")
    public ResponseEntity<?> create(@RequestBody dtoSkills dtoskills){
        if(StringUtils.isBlank(dtoskills.getNombreS())){
            return new ResponseEntity(new Mensaje("El nombre de la Skill es obligatorio"), HttpStatus.BAD_REQUEST);
            
        }
        if(sSkills.existsByNombreS(dtoskills.getNombreS())){
            return new ResponseEntity(new Mensaje("Ya se incorporo esa Skills"), HttpStatus.BAD_REQUEST);
        }
        Skills skil = new Skills(dtoskills.getImgS(),dtoskills.getNombreS(),dtoskills.getPorcentajeS());
        sSkills.save(skil);
        return new ResponseEntity(new Mensaje("Skill Añadida"),HttpStatus.OK);
        
    }
    
    @PutMapping("/update/{id}")
    public ResponseEntity<?> update(@PathVariable("id") int id, @RequestBody dtoSkills dtoskills){
        if(!sSkills.existsById(id)){
            return new ResponseEntity(new Mensaje("El ID no existe"), HttpStatus.BAD_REQUEST);
        }
        if(sSkills.existsByNombreS(dtoskills.getNombreS()) && sSkills.getByNombreS(dtoskills.getNombreS()).get().getId()!=id){
            return new ResponseEntity(new Mensaje("Esa Skill ya existe"), HttpStatus.BAD_REQUEST);
        }
        if(StringUtils.isBlank(dtoskills.getNombreS())){
            return new ResponseEntity(new Mensaje("El nombre de la skills es obligatorio"), HttpStatus.BAD_REQUEST);
        }
        Skills skil=sSkills.getOne(id).get();
        skil.setImgS(dtoskills.getImgS());
        skil.setNombreS(dtoskills.getNombreS());
        skil.setPorcentajeS(dtoskills.getPorcentajeS());
        sSkills.save(skil);
        return new ResponseEntity(new Mensaje("Skill Actualizada"),HttpStatus.OK);
    }   
}