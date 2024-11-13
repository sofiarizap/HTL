package SofiaAriza.e_commerce.Servicios.Implementaciones;

import SofiaAriza.e_commerce.Models.Usuario;
import SofiaAriza.e_commerce.Repositorios.RepositorioUsuario;
import SofiaAriza.e_commerce.Servicios.UsuarioService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class UsuarioServiceImpl implements UsuarioService {

  @Autowired
  private RepositorioUsuario usuarioRepository;

  @Override
  public Usuario registrarUsuario(Usuario usuario) {
    // Lógica de validación adicional si es necesario
    return usuarioRepository.save(usuario);
  }

  @Override
  public Usuario obtenerUsuarioPorId(Long id) {
    return usuarioRepository.findById(id)
            .orElseThrow(() -> new RuntimeException("Usuario no encontrado con ID: " + id));
  }

  @Override
  public Usuario actualizarUsuario(Long id, Usuario usuarioActualizado) {
    Usuario usuarioExistente = obtenerUsuarioPorId(id);
    usuarioExistente.setUsername(usuarioActualizado.getUsername());
    return usuarioRepository.save(usuarioExistente);
  }

  @Override
  public void eliminarUsuario(Long id) {
    usuarioRepository.deleteById(id);
  }
}
