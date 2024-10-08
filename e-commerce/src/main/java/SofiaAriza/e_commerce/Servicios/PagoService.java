package SofiaAriza.e_commerce.Servicios;

import SofiaAriza.e_commerce.Models.Pago;

import java.util.List;

public interface PagoService {
  Pago procesarPago(Pago pago);
  Pago obtenerPagoPorId(Long id);
  List<Pago> obtenerPagosPorCliente(Long clienteId);
}
