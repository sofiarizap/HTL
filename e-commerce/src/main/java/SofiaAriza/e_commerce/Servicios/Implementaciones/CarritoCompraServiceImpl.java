package SofiaAriza.e_commerce.Servicios.Implementaciones;

import SofiaAriza.e_commerce.Models.CarritoCompra;
import SofiaAriza.e_commerce.Models.Cliente;
import SofiaAriza.e_commerce.Models.ItemCarrito;
import SofiaAriza.e_commerce.Models.Producto;
import SofiaAriza.e_commerce.Repositorios.RepositorioCarritoCompra;
import SofiaAriza.e_commerce.Repositorios.RepositorioCliente;
import SofiaAriza.e_commerce.Repositorios.RepositorioProducto;
import SofiaAriza.e_commerce.Servicios.CarritoCompraService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.rest.webmvc.ResourceNotFoundException;
import org.springframework.stereotype.Service;

import java.util.Optional;

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
            .orElseThrow(() -> new RuntimeException("Carrito no encontrado"));
  }

  @Override
  public CarritoCompra agregarProductoAlCarrito(Long clienteId, Long productoId, int cantidad) {
    Optional<Cliente> clienteOpt = clienteRepository.findById(clienteId);
    Optional<Producto> productoOpt = productoRepository.findById(productoId);

    if (clienteOpt.isPresent() && productoOpt.isPresent()) {
      Cliente cliente = clienteOpt.get();
      Producto producto = productoOpt.get();
      CarritoCompra carrito = obtenerCarritoPorCliente(clienteId);

      ItemCarrito item = new ItemCarrito();
      item.setProducto(producto);
      item.setCantidad(cantidad);
      carrito.getItems().add(item);

      return carritoCompraRepository.save(carrito);
    } else {
      throw new RuntimeException("Cliente o Producto no encontrados");
    }
  }

  @Override
  public void eliminarProductoDelCarrito(Long clienteId, Long productoId) {
    CarritoCompra carrito = obtenerCarritoPorCliente(clienteId);
    carrito.getItems().removeIf(item -> item.getProducto().getId().equals(productoId));
    carritoCompraRepository.save(carrito);
  }

  @Override
  public void vaciarCarrito(Long clienteId) {
    CarritoCompra carrito = obtenerCarritoPorCliente(clienteId);
    carrito.getItems().clear();
    carritoCompraRepository.save(carrito);
  }
}

