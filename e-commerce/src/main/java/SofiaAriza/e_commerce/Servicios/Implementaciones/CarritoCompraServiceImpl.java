package SofiaAriza.e_commerce.Servicios.Implementaciones;

import SofiaAriza.e_commerce.Models.CarritoCompra;
import SofiaAriza.e_commerce.Models.Producto;
import SofiaAriza.e_commerce.Repositorios.RepositorioCarritoCompra;
import SofiaAriza.e_commerce.Repositorios.RepositorioCliente;
import SofiaAriza.e_commerce.Repositorios.RepositorioProducto;
import SofiaAriza.e_commerce.Servicios.CarritoCompraService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.rest.webmvc.ResourceNotFoundException;
import org.springframework.stereotype.Service;

@Service
public class CarritoCompraServiceImpl implements CarritoCompraService {

  @Autowired
  private RepositorioCarritoCompra carritoCompraRepository;

  @Autowired
  private RepositorioProducto productoRepository;

  @Autowired
  private RepositorioCliente clienteRepository;

  @Override
  public CarritoCompra obtenerCarritoPorCliente(Long clienteId) {
    return carritoCompraRepository.findByClienteId(clienteId)
            .orElseThrow(() -> new ResourceNotFoundException("Carrito no encontrado para el cliente con id: " + clienteId));
  }

  @Override
  public CarritoCompra agregarProductoAlCarrito(Long clienteId, Long productoId, int cantidad) {
    CarritoCompra carrito = obtenerCarritoPorCliente(clienteId);
    Producto producto = productoRepository.findById(productoId)
            .orElseThrow(() -> new ResourceNotFoundException("Producto no encontrado con id: " + productoId));

    carrito.agregarProducto(producto, cantidad);  // Método dentro de la entidad CarritoCompra
    return carritoCompraRepository.save(carrito);
  }

  @Override
  public void eliminarProductoDelCarrito(Long clienteId, Long productoId) {
    CarritoCompra carrito = obtenerCarritoPorCliente(clienteId);
    carrito.eliminarProducto(productoId);
    carritoCompraRepository.save(carrito);
  }

  @Override
  public void vaciarCarrito(Long clienteId) {
    CarritoCompra carrito = obtenerCarritoPorCliente(clienteId);
    carrito.vaciarCarrito();
    carritoCompraRepository.save(carrito);
  }
}

