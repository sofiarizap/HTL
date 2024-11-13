package SofiaAriza.e_commerce.Servicios;

import SofiaAriza.e_commerce.Models.Cliente;
import SofiaAriza.e_commerce.Models.Pedido;

import java.util.List;

public interface ClienteService {
  Cliente crearCliente(Cliente cliente);
  Cliente obtenerClientePorId(Long id);
  Cliente actualizarCliente(Long id, Cliente cliente);
  void eliminarCliente(Long id);
  List<Pedido> obtenerPedidosPorCliente(Long id);
}