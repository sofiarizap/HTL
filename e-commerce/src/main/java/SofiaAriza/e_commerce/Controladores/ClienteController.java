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
@RequestMapping("/api")
public class ClienteController {

  @Autowired
  private ClienteService clienteService;

  @PostMapping(path = "/clientes")
  public ResponseEntity<Object> register(@RequestParam String nombre, @RequestParam String direccion,
                                         @RequestParam String telefono, @RequestParam String ciudad ) {


    if (nombre.isEmpty() ) {
      return new ResponseEntity<>("ESPACIO DE NOMBRE VACIO", HttpStatus.FORBIDDEN);
    }
    if ( direccion.isEmpty()  ) {
      return new ResponseEntity<>("ESPACIO DE DIRECCION VACIO", HttpStatus.FORBIDDEN);
    }
    if ( telefono.isEmpty() ) {
      return new ResponseEntity<>("ESPACIO DE TELEFONO VACIO", HttpStatus.FORBIDDEN);
    }
    if ( ciudad.isEmpty() ) {
      return new ResponseEntity<>("ESPACIO DE CIUDAD VACIO", HttpStatus.FORBIDDEN);
    }







    return new ResponseEntity<> ("SUCCESSFUL REGISTRATION",HttpStatus.CREATED);
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

