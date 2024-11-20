package SofiaAriza.e_commerce.Servicios;

import SofiaAriza.e_commerce.Models.Producto;

import java.util.List;

public interface ProductoService {
  Producto crearProducto(Producto producto);
  Producto obtenerProductoPorId(Long id);
  List<Producto> obtenerTodosLosProductos();
  Producto actualizarProducto(Long id, Producto producto);
  void eliminarProducto(Long id);
}
