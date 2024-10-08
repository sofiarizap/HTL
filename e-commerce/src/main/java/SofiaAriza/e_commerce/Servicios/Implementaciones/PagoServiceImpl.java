package SofiaAriza.e_commerce.Servicios.Implementaciones;

import SofiaAriza.e_commerce.Models.Cliente;
import SofiaAriza.e_commerce.Models.Pago;
import SofiaAriza.e_commerce.Repositorios.RepositorioCliente;
import SofiaAriza.e_commerce.Repositorios.RepositorioPago;
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

  @Override
  public Pago procesarPago(Pago pago) {
    // Lógica para procesar el pago (ejemplo: llamar a un sistema de pagos)
    return pagoRepository.save(pago);
  }

  @Override
  public Pago obtenerPagoPorId(Long id) {
    return pagoRepository.findById(id)
            .orElseThrow(() -> new ResourceNotFoundException("Pago no encontrado con id: " + id));
  }

  @Override
  public List<Pago> obtenerPagosPorCliente(Long clienteId) {
    Cliente cliente = clienteRepository.findById(clienteId)
            .orElseThrow(() -> new ResourceNotFoundException("Cliente no encontrado con id: " + clienteId));
    return pagoRepository.findByCliente(cliente);
  }
}
