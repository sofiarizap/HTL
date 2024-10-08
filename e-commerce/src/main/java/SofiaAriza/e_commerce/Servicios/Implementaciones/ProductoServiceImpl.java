package SofiaAriza.e_commerce.Servicios.Implementaciones;

import SofiaAriza.e_commerce.Models.Producto;
import SofiaAriza.e_commerce.Repositorios.RepositorioProducto;
import SofiaAriza.e_commerce.Servicios.ProductoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.rest.webmvc.ResourceNotFoundException;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ProductoServiceImpl implements ProductoService {

  @Autowired
  private RepositorioProducto productoRepository;

  @Override
  public Producto crearProducto(Producto producto) {
    return productoRepository.save(producto);
  }

  @Override
  public Producto obtenerProductoPorId(Long id) {
    return productoRepository.findById(id)
            .orElseThrow(() -> new ResourceNotFoundException("Producto no encontrado con id: " + id));
  }

  @Override
  public List<Producto> obtenerTodosLosProductos() {
    return productoRepository.findAll();
  }

  @Override
  public void eliminarProducto(Long id) {
    productoRepository.deleteById(id);
  }
}

