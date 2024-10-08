package SofiaAriza.e_commerce.Servicios;

import SofiaAriza.e_commerce.Models.Producto;

import java.util.List;

public interface ProductoService {
  Producto crearProducto(Producto producto);
  Producto obtenerProductoPorId(Long id);
  List<Producto> obtenerTodosLosProductos();
  void eliminarProducto(Long id);
}

