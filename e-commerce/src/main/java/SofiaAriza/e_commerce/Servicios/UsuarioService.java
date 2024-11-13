package SofiaAriza.e_commerce.Servicios;

import SofiaAriza.e_commerce.Models.Usuario;

public interface UsuarioService {
  Usuario registrarUsuario(Usuario usuario);
  Usuario obtenerUsuarioPorId(Long id);
  Usuario actualizarUsuario(Long id, Usuario usuario);
  void eliminarUsuario(Long id);
}
