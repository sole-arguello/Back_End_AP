
package com.portfolio.msa.Interface;

import com.portfolio.msa.Entity.Persona;
import java.util.List;


public interface IPersonaService {
    
        //traer persona trae una lista de personas
    public List<Persona> getPersona();
    //guardar un objeto de tipo persona
    public void savePersona(Persona persona);
    //eliminar un objeto por el id
    public void deletePersona(Long id);
    //buscar una persona
    public Persona findPersona(Long id);
    
}
