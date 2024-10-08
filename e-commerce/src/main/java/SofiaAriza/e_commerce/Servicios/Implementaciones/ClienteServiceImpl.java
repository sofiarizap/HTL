package SofiaAriza.e_commerce.Servicios.Implementaciones;

import SofiaAriza.e_commerce.Models.Cliente;
import SofiaAriza.e_commerce.Repositorios.RepositorioCliente;
import SofiaAriza.e_commerce.Servicios.ClienteService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.rest.webmvc.ResourceNotFoundException;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ClienteServiceImpl implements ClienteService {

  @Autowired
  private RepositorioCliente clienteRepository;

  @Override
  public Cliente crearCliente(Cliente cliente) {
    return clienteRepository.save(cliente);
  }

  @Override
  public Cliente obtenerClientePorId(Long id) {
    return clienteRepository.findById(id)
            .orElseThrow(() -> new ResourceNotFoundException("Cliente no encontrado con id: " + id));
  }

  @Override
  public List<Cliente> obtenerTodosLosClientes() {
    return clienteRepository.findAll();
  }

  @Override
  public void eliminarCliente(Long id) {
    clienteRepository.deleteById(id);
  }
}

