package SofiaAriza.e_commerce.Servicios;

import SofiaAriza.e_commerce.Models.Rol;
import SofiaAriza.e_commerce.Models.Usuario;
import java.util.List;

public interface RolService {
  Rol crearRol(Rol rol);
  List<Rol> listarRoles();
  Usuario asignarRolAUsuario(Long usuarioId, Long rolId);
}
