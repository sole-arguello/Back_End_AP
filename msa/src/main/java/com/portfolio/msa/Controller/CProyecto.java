
package com.portfolio.msa.Controller;

import com.portfolio.msa.Dto.dtoProyecto;
import com.portfolio.msa.Entity.Proyecto;
import com.portfolio.msa.Security.Controller.Mensaje;
import com.portfolio.msa.Service.SProyecto;
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
@RequestMapping("proyecto")
//@CrossOrigin((origins="https://frontend-arg.web.app")
@CrossOrigin(origins="http://localhost:4200")

public class CProyecto {
    @Autowired
    SProyecto sProyecto;
    
    @GetMapping("/lista")
    public ResponseEntity<List<Proyecto>> list(){
        List<Proyecto> list=sProyecto.list();
        return new ResponseEntity(list,HttpStatus.OK);
    }
     @GetMapping("/detail/{id}")
     public ResponseEntity<Proyecto>getById(@PathVariable("id") int id){
         if(!sProyecto.existsById(id))
             return new ResponseEntity(new Mensaje("No existe"), HttpStatus.NOT_FOUND);
         Proyecto proyecto=sProyecto.getOne(id).get();
         return new ResponseEntity(proyecto,HttpStatus.OK);
     }
      @DeleteMapping("/delete/{id}")
      public ResponseEntity<?> delete(@PathVariable("id") int id){
          if(!sProyecto.existsById(id)){
              return new ResponseEntity(new Mensaje("no existe"), HttpStatus.NOT_FOUND);
          }
          sProyecto.delete(id);
          return new ResponseEntity(new Mensaje("Proyecto Eliminado"), HttpStatus.OK);
      }
      
       @PostMapping("/create")
       public ResponseEntity<?>create(@RequestBody dtoProyecto dtoproy){
           if(StringUtils.isBlank(dtoproy.getNombreP())){
               return new ResponseEntity(new Mensaje("El nombre del proyecto es obligatorio"), HttpStatus.BAD_REQUEST);
           }
           if(sProyecto.existsByNompreP(dtoproy.getNombreP())){
               return new ResponseEntity(new Mensaje("ya se incorporo ese proyecto"), HttpStatus.BAD_REQUEST);
           }
           Proyecto proyecto=new Proyecto(dtoproy.getImgP(),dtoproy.getNombreP(),dtoproy.getDescripcionP(), dtoproy.getPaginaP(), dtoproy.getRepositorioP());
               
           sProyecto.save(proyecto);
           return new ResponseEntity(new Mensaje("Proyecto agregado"),HttpStatus.OK);
       }
       
       @PutMapping("/update/{id}")
       public ResponseEntity<?> update(@PathVariable("id")int id,@RequestBody dtoProyecto dtoproy){
           if(!sProyecto.existsById(id)){
               return new ResponseEntity(new Mensaje("El ID no existe"),HttpStatus.BAD_REQUEST);
               
           }
           if(sProyecto.existsByNompreP(dtoproy.getNombreP())&& sProyecto.getByNombreP(dtoproy.getNombreP()).get().getId() !=id){
               return new ResponseEntity(new Mensaje("Ese Proyecto ya existe"),HttpStatus.BAD_REQUEST);
           }
           if(StringUtils.isBlank(dtoproy.getNombreP())){
               return new ResponseEntity(new Mensaje("el nombre del proyecto es obligatorio"),HttpStatus.BAD_REQUEST);
            }
           Proyecto proyecto=sProyecto.getOne(id).get();
           proyecto.setImgP(dtoproy.getImgP());
           proyecto.setNombreP(dtoproy.getNombreP());
           proyecto.setDescripcionP(dtoproy.getDescripcionP());
           proyecto.setPaginaP(dtoproy.getPaginaP());
           proyecto.setRepositorioP(dtoproy.getRepositorioP());
           sProyecto.save(proyecto);
           return new ResponseEntity(new Mensaje("Proyecto actualizado"),HttpStatus.OK);
       }
}
