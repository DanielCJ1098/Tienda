package com.tienda.service;
import com.tienda.domain.Articulo;
import java.util.List;
public interface ArticuloService {
    public List<Articulo> getArticulos(boolean activo);
    public Articulo getArticulo(Articulo Articulo);
    public void save(Articulo Articulo);
    public void delete(Articulo Articulo);
}