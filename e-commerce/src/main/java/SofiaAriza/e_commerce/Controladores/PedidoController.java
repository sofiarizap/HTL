package SofiaAriza.e_commerce.Controladores;

import SofiaAriza.e_commerce.Models.Pedido;
import SofiaAriza.e_commerce.Servicios.PedidoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/pedidos")
public class PedidoController {

  @Autowired
  private PedidoService pedidoService;

  @PostMapping
  public ResponseEntity<Pedido> crearPedido(@RequestBody Pedido pedido) {
    Pedido nuevoPedido = pedidoService.crearPedido(pedido);
    return ResponseEntity.status(HttpStatus.CREATED).body(nuevoPedido);
  }

  @GetMapping("/{id}")
  public ResponseEntity<Pedido> obtenerPedido(@PathVariable Long id) {
    Pedido pedido = pedidoService.obtenerPedidoPorId(id);
    return ResponseEntity.ok(pedido);
  }

  @GetMapping
  public ResponseEntity<List<Pedido>> listarPedidos() {
    List<Pedido> pedidos = pedidoService.listarPedidos();
    return ResponseEntity.ok(pedidos);
  }

  @PutMapping("/{id}")
  public ResponseEntity<Pedido> actualizarPedido(@PathVariable Long id, @RequestBody Pedido pedido) {
    Pedido pedidoActualizado = pedidoService.actualizarPedido(id, pedido);
    return ResponseEntity.ok(pedidoActualizado);
  }

  @DeleteMapping("/{id}")
  public ResponseEntity<Void> eliminarPedido(@PathVariable Long id) {
    pedidoService.eliminarPedido(id);
    return ResponseEntity.noContent().build();
  }
}
