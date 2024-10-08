package SofiaAriza.e_commerce.Controladores;
import SofiaAriza.e_commerce.Models.Cliente;
import SofiaAriza.e_commerce.Models.Pedido;
import SofiaAriza.e_commerce.Servicios.ClienteService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/clientes")
public class ClienteController {

  @Autowired
  private ClienteService clienteService;

  @PostMapping
  public ResponseEntity<Cliente> registrarCliente(@RequestBody Cliente cliente) {
    Cliente nuevoCliente = clienteService.crearCliente(cliente);
    return ResponseEntity.status(HttpStatus.CREATED).body(nuevoCliente);
  }

  @GetMapping("/{id}")
  public ResponseEntity<Cliente> obtenerCliente(@PathVariable Long id) {
    Cliente cliente = clienteService.obtenerClientePorId(id);
    return ResponseEntity.ok(cliente);
  }

  @PutMapping("/{id}")
  public ResponseEntity<Cliente> actualizarCliente(@PathVariable Long id, @RequestBody Cliente cliente) {
    Cliente clienteActualizado = clienteService.actualizarCliente(id, cliente);
    return ResponseEntity.ok(clienteActualizado);
  }

  @DeleteMapping("/{id}")
  public ResponseEntity<Void> eliminarCliente(@PathVariable Long id) {
    clienteService.eliminarCliente(id);
    return ResponseEntity.noContent().build();
  }

  // Método para obtener los pedidos de un cliente
  @GetMapping("/{id}/pedidos")
  public ResponseEntity<List<Pedido>> obtenerPedidosPorCliente(@PathVariable Long id) {
    List<Pedido> pedidos = clienteService.obtenerPedidosPorCliente(id);
    return ResponseEntity.ok(pedidos);
  }
}

