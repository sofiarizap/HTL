package SofiaAriza.e_commerce.Controladores;

import SofiaAriza.e_commerce.Models.Pago;
import SofiaAriza.e_commerce.Servicios.PagoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/pagos")
public class PagoController {

  @Autowired
  private PagoService pagoService;

  @PostMapping("/{pedidoId}")
  public ResponseEntity<Pago> realizarPago(@PathVariable Long pedidoId, @RequestBody Pago pago) {
    Pago nuevoPago = pagoService.realizarPago(pedidoId, pago);
    return ResponseEntity.status(HttpStatus.CREATED).body(nuevoPago);
  }

  @GetMapping("/{id}")
  public ResponseEntity<Pago> obtenerPago(@PathVariable Long id) {
    Pago pago = pagoService.obtenerPagoPorId(id);
    return ResponseEntity.ok(pago);
  }

  @DeleteMapping("/{id}")
  public ResponseEntity<Void> eliminarPago(@PathVariable Long id) {
    pagoService.eliminarPago(id);
    return ResponseEntity.noContent().build();
  }
}

