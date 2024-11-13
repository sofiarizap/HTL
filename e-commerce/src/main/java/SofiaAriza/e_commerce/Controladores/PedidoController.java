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

  // Ajuste para obtener pedidos por cliente
  @GetMapping("/cliente/{clienteId}")
  public ResponseEntity<List<Pedido>> obtenerPedidosPorCliente(@PathVariable Long clienteId) {
    List<Pedido> pedidos = pedidoService.obtenerPedidosPorCliente(clienteId);
    return ResponseEntity.ok(pedidos);
  }



  @DeleteMapping("/{id}")
  public ResponseEntity<Void> eliminarPedido(@PathVariable Long id) {
    pedidoService.eliminarPedido(id);
    return ResponseEntity.noContent().build();
  }
}
