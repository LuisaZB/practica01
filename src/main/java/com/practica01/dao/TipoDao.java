
package com.practica01.dao;

import com.practica01.domain.Tipo;
import org.springframework.data.jpa.repository.JpaRepository;


public interface TipoDao extends JpaRepository<Tipo, Long> {
    
}
