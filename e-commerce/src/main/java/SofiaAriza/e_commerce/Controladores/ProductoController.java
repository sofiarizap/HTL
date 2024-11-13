package SofiaAriza.e_commerce.Controladores;

import SofiaAriza.e_commerce.Models.Producto;
import SofiaAriza.e_commerce.Servicios.ProductoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/productos")
public class ProductoController {

  @Autowired
  private ProductoService productoService;

  @PostMapping
  public ResponseEntity<Producto> crearProducto(@RequestBody Producto producto) {
    Producto nuevoProducto = productoService.crearProducto(producto);
    return ResponseEntity.status(HttpStatus.CREATED).body(nuevoProducto);
  }

  @GetMapping("/{id}")
  public ResponseEntity<Producto> obtenerProducto(@PathVariable Long id) {
    Producto producto = productoService.obtenerProductoPorId(id);
    return ResponseEntity.ok(producto);
  }

  @GetMapping
  public ResponseEntity<List<Producto>> obtenerTodosLosProductos() { // Ajustado para coincidir con la interfaz
    List<Producto> productos = productoService.obtenerTodosLosProductos();
    return ResponseEntity.ok(productos);
  }

  @PutMapping("/{id}")
  public ResponseEntity<Producto> actualizarProducto(@PathVariable Long id, @RequestBody Producto producto) {
    Producto productoActualizado = productoService.actualizarProducto(id, producto);
    return ResponseEntity.ok(productoActualizado);
  }

  @DeleteMapping("/{id}")
  public ResponseEntity<Void> eliminarProducto(@PathVariable Long id) {
    productoService.eliminarProducto(id);
    return ResponseEntity.noContent().build();
  }
}
