package SofiaAriza.e_commerce.Controladores;

import SofiaAriza.e_commerce.Models.CarritoCompra;
import SofiaAriza.e_commerce.Models.ItemCarrito;
import SofiaAriza.e_commerce.Servicios.CarritoCompraService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/carrito")
public class CarritoCompraController {

  @Autowired
  private CarritoCompraService carritoCompraService;

  @PostMapping("/{clienteId}/agregar")
  public ResponseEntity<CarritoCompra> agregarProductoAlCarrito(@PathVariable Long clienteId, @RequestBody ItemCarrito itemCarrito) {
    CarritoCompra carritoCompra = carritoCompraService.agregarProducto(clienteId, itemCarrito);
    return ResponseEntity.ok(carritoCompra);
  }

  @GetMapping("/{clienteId}")
  public ResponseEntity<CarritoCompra> verCarrito(@PathVariable Long clienteId) {
    CarritoCompra carritoCompra = carritoCompraService.obtenerCarritoPorCliente(clienteId);
    return ResponseEntity.ok(carritoCompra);
  }

  @DeleteMapping("/{clienteId}/eliminar/{itemId}")
  public ResponseEntity<Void> eliminarProductoDelCarrito(@PathVariable Long clienteId, @PathVariable Long itemId) {
    carritoCompraService.eliminarProducto(clienteId, itemId);
    return ResponseEntity.noContent().build();
  }

  @PostMapping("/{clienteId}/vaciar")
  public ResponseEntity<Void> vaciarCarrito(@PathVariable Long clienteId) {
    carritoCompraService.vaciarCarrito(clienteId);
    return ResponseEntity.noContent().build();
  }
}

