
package com.portfolio.msa.Controller;

import com.portfolio.msa.Dto.dtoRedes;
import com.portfolio.msa.Entity.Redes;
import com.portfolio.msa.Security.Controller.Mensaje;
import com.portfolio.msa.Service.SRedes;
import java.util.List;
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
@RequestMapping("red")
@CrossOrigin(origins="http://localhost:4200")
//@CrossOrigin((origins="https://frontend-arg.web.app")
public class CRedes {
     @Autowired
     SRedes sRedes;
     
     @GetMapping("/lista")
     public ResponseEntity<List<Redes>> list(){
         List<Redes>list=sRedes.list();
         return new ResponseEntity(list,HttpStatus.OK);
     }
     
     @GetMapping("/detail/{id}")
     public ResponseEntity<Redes>getById(@PathVariable("id") int id){
         if(!sRedes.existsById(id))
             return new ResponseEntity(new Mensaje("No existe"),HttpStatus.NOT_FOUND);
         Redes redes=sRedes.getOne(id).get();
         return new ResponseEntity(redes,HttpStatus.OK);
     }
     
      @DeleteMapping("/delete/{id}")
      public ResponseEntity<?>delete(@PathVariable("id") int id){
          if(!sRedes.existsById(id)){
              return new ResponseEntity(new Mensaje("No existe"),HttpStatus.NOT_FOUND);
          }
          sRedes.delete(id);
          return new ResponseEntity(new Mensaje("Red eliminada"), HttpStatus.OK);
      }
     @PostMapping("/create")
     public ResponseEntity<?>create(@RequestBody dtoRedes dtored){
         Redes redes=new Redes(dtored.getImgRed(),dtored.getLinkRed());
         sRedes.save(redes);
         return new ResponseEntity(new Mensaje("Red Añadida"), HttpStatus.OK);
         
     }
     
     
     @PutMapping("/update/{id}")
     public ResponseEntity<?>update(@PathVariable("id") int id, @RequestBody dtoRedes dtored){
         Redes redes =sRedes.getOne(id).get();
         redes.setImgRed(dtored.getImgRed());
         redes.setLinkRed(dtored.getLinkRed());
        
         sRedes.save(redes);
         return new ResponseEntity(new Mensaje("actualizado"),HttpStatus.OK);
     }
}
