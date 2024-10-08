package SofiaAriza.e_commerce.Servicios.Implementaciones;

import SofiaAriza.e_commerce.Models.Cliente;
import SofiaAriza.e_commerce.Models.Pedido;
import SofiaAriza.e_commerce.Repositorios.RepositorioCliente;
import SofiaAriza.e_commerce.Repositorios.RepositorioPedido;
import SofiaAriza.e_commerce.Servicios.PedidoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.rest.webmvc.ResourceNotFoundException;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class PedidoServiceImpl implements PedidoService {

  @Autowired
  private RepositorioPedido pedidoRepository;

  @Autowired
  private RepositorioCliente clienteRepository;

  @Override
  public Pedido crearPedido(Pedido pedido) {
    return pedidoRepository.save(pedido);
  }

  @Override
  public Pedido obtenerPedidoPorId(Long id) {
    return pedidoRepository.findById(id)
            .orElseThrow(() -> new ResourceNotFoundException("Pedido no encontrado con id: " + id));
  }

  @Override
  public List<Pedido> obtenerPedidosPorCliente(Long clienteId) {
    Cliente cliente = clienteRepository.findById(clienteId)
            .orElseThrow(() -> new ResourceNotFoundException("Cliente no encontrado con id: " + clienteId));
    return pedidoRepository.findByCliente(cliente);
  }

  @Override
  public void eliminarPedido(Long id) {
    pedidoRepository.deleteById(id);
  }
}

