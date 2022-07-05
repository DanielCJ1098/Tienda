package com.tienda.service;
import com.tienda.domain.Categoria;
import java.util.List;
public interface CategoriaService {
    public List<Categoria> getCategorias(boolean activo);
    public Categoria getCategoria(Categoria Categoria);
    public void save(Categoria Categoria);
    public void delete(Categoria Categoria);
}