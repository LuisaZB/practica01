
package com.practica01.service.impl;

import com.practica01.dao.TipoDao;
import com.practica01.domain.Tipo;
import com.practica01.service.TipoService;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
public class TipoServimeImpl implements TipoService{

    @Autowired
    private TipoDao tipoDao;
    
    @Override
    @Transactional(readOnly = true)
    public List<Tipo> getTipos(boolean activos) {
        var lista = tipoDao.findAll();
        if (activos) {
            lista.removeIf(c -> !c.isActivo());
        }
        return lista;
    }

    @Override
    public Tipo getTipo(Tipo tipo) {
        return tipoDao.findById(tipo.getIdArbol()).orElse(null);
    }

    @Override
    public void save(Tipo tipo) {
      tipoDao.save(tipo);
    }

    @Override
    public void delete(Tipo tipo) {
        tipoDao.delete(tipo);
    }
    
}
