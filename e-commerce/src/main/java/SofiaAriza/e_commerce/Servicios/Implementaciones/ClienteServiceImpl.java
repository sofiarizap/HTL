package SofiaAriza.e_commerce.Servicios.Implementaciones;

import SofiaAriza.e_commerce.Models.Cliente;
import SofiaAriza.e_commerce.Models.Pedido;
import SofiaAriza.e_commerce.Repositorios.RepositorioCliente;
import SofiaAriza.e_commerce.Repositorios.RepositorioPedido;
import SofiaAriza.e_commerce.Servicios.ClienteService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.rest.webmvc.ResourceNotFoundException;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ClienteServiceImpl implements ClienteService {

  @Autowired
  private RepositorioCliente clienteRepository;
  @Autowired
  private RepositorioPedido pedidoRepository;


  @Override
  public Cliente crearCliente(Cliente cliente) {
    return clienteRepository.save(cliente);
  }

  @Override
  public Cliente obtenerClientePorId(Long id) {
    return clienteRepository.findById(id)
            .orElseThrow(() -> new RuntimeException("Cliente no encontrado"));
  }

  @Override
  public Cliente actualizarCliente(Long id, Cliente cliente) {
    Cliente clienteExistente = obtenerClientePorId(id);
    clienteExistente.setNombre(cliente.getNombre());
    clienteExistente.setEmail(cliente.getEmail());
    // Actualiza otros campos según corresponda
    return clienteRepository.save(clienteExistente);
  }

  @Override
  public void eliminarCliente(Long id) {
    clienteRepository.deleteById(id);
  }

  @Override
  public List<Pedido> obtenerPedidosPorCliente(Long id) {
    Cliente cliente = obtenerClientePorId(id);
    return pedidoRepository.findByCliente(cliente);
  }
}

