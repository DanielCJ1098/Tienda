package com.tienda.service;

import com.tienda.dao.CategoriaDao;
import com.tienda.domain.Categoria;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
public class CategoriaServiceImpl implements CategoriaService {

    @Autowired
    private CategoriaDao categoriaDao;

    @Override
    @Transactional(readOnly = true)
    public List<Categoria> getCategorias(boolean activo) { //activo = true
        var lista = (List<Categoria>)categoriaDao.findAll(); 

        if (activo) {
            lista.removeIf(e -> !e.isActivo());
        }

        return lista;
    }

    @Override
    @Transactional(readOnly = true)
    public Categoria getCategoria(Categoria Categoria) {
        return categoriaDao.findById(Categoria.getIdCategoria()).orElse(null);
    }

    @Override
    @Transactional
    public void save(Categoria Categoria) {
        categoriaDao.save(Categoria);
    }

    @Override
    public void delete(Categoria Categoria) {
        categoriaDao.delete(Categoria);
    }
}
