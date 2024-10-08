package SofiaAriza.e_commerce.Servicios;

import SofiaAriza.e_commerce.Models.Cliente;

import java.util.List;

public interface ClienteService {
  Cliente crearCliente(Cliente cliente);
  Cliente obtenerClientePorId(Long id);
  List<Cliente> obtenerTodosLosClientes();
  void eliminarCliente(Long id);
}
