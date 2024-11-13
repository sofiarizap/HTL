package SofiaAriza.e_commerce.Servicios.Implementaciones;

import SofiaAriza.e_commerce.Models.Rol;
import SofiaAriza.e_commerce.Models.Usuario;
import SofiaAriza.e_commerce.Repositorios.RepositorioRol;
import SofiaAriza.e_commerce.Repositorios.RepositorioUsuario;
import SofiaAriza.e_commerce.Servicios.RolService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class RolServiceImpl implements RolService {

  @Autowired
  private RepositorioRol rolRepository;

  @Autowired
  private RepositorioUsuario usuarioRepository;

  @Override
  public Rol crearRol(Rol rol) {
    return rolRepository.save(rol);
  }

  @Override
  public List<Rol> listarRoles() {
    return rolRepository.findAll();
  }

  @Override
  public Usuario asignarRolAUsuario(Long usuarioId, Long rolId) {
    Usuario usuario = usuarioRepository.findById(usuarioId)
            .orElseThrow(() -> new RuntimeException("Usuario no encontrado"));
    Rol rol = rolRepository.findById(rolId)
            .orElseThrow(() -> new RuntimeException("Rol no encontrado"));

    usuario.getRoles().add(rol);
    return usuarioRepository.save(usuario);
  }
}
