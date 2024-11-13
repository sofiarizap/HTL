package SofiaAriza.e_commerce.Servicios;

import SofiaAriza.e_commerce.Models.Pago;

import java.util.List;

public interface PagoService {
  Pago realizarPago(Long pedidoId, Pago pago); // Ajuste realizado aquí
  Pago obtenerPagoPorId(Long id);
  List<Pago> obtenerPagosPorCliente(Long clienteId);
  void eliminarPago(Long id); // Ajuste realizado aquí
}
