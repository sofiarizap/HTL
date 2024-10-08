package SofiaAriza.e_commerce.Servicios;

import SofiaAriza.e_commerce.Models.Pedido;

import java.util.List;

public interface PedidoService {
  Pedido crearPedido(Pedido pedido);
  Pedido obtenerPedidoPorId(Long id);
  List<Pedido> obtenerPedidosPorCliente(Long clienteId);
  void eliminarPedido(Long id);
}

