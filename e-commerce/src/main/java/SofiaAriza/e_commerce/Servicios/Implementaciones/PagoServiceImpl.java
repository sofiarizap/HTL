package SofiaAriza.e_commerce.Servicios.Implementaciones;

import SofiaAriza.e_commerce.Models.Cliente;
import SofiaAriza.e_commerce.Models.Pago;
import SofiaAriza.e_commerce.Models.Pedido;
import SofiaAriza.e_commerce.Repositorios.RepositorioCliente;
import SofiaAriza.e_commerce.Repositorios.RepositorioPago;
import SofiaAriza.e_commerce.Repositorios.RepositorioPedido;
import SofiaAriza.e_commerce.Servicios.PagoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.rest.webmvc.ResourceNotFoundException;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class PagoServiceImpl implements PagoService {

  @Autowired
  private RepositorioPago pagoRepository;

  @Autowired
  private RepositorioCliente clienteRepository;
  @Autowired
  private RepositorioPedido pedidoRepository;

  @Override
  public Pago realizarPago(Long pedidoId, Pago pago) {
    Pedido pedido = pedidoRepository.findById(pedidoId)
            .orElseThrow(() -> new RuntimeException("Pedido no encontrado"));

    pago.setPedido(pedido); // Enlaza el pago al pedido correspondiente
    return pagoRepository.save(pago);
  }

  @Override
  public Pago obtenerPagoPorId(Long id) {
    return pagoRepository.findById(id)
            .orElseThrow(() -> new RuntimeException("Pago no encontrado"));
  }

  @Override
  public List<Pago> obtenerPagosPorCliente(Long clienteId) {
    return pagoRepository.findByClienteId(clienteId);
  }

  @Override
  public void eliminarPago(Long id) {
    pagoRepository.deleteById(id);
  }
}
