package SofiaAriza.e_commerce.Servicios;

import SofiaAriza.e_commerce.Models.CarritoCompra;

public interface CarritoCompraService {
  CarritoCompra obtenerCarritoPorCliente(Long clienteId);
  CarritoCompra agregarProductoAlCarrito(Long clienteId, Long productoId, int cantidad);
  void eliminarProductoDelCarrito(Long clienteId, Long productoId);
  void vaciarCarrito(Long clienteId);
}
