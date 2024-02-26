
package com.practica01.service;

import com.practica01.domain.Tipo;
import java.util.List;


public interface TipoService {
    public List<Tipo> getTipos(boolean activos);
    
    public Tipo getTipo(Tipo tipo);
    
    public void save(Tipo tipo);
    
    public void delete(Tipo tipo);
}
