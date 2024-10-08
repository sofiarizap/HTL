package SofiaAriza.e_commerce.Controladores;

import SofiaAriza.e_commerce.Models.Usuario;
import SofiaAriza.e_commerce.Servicios.UsuarioService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/usuarios")
public class UsuarioController {

  @Autowired
  private UsuarioService usuarioService;

  @PostMapping("/registro")
  public ResponseEntity<Usuario> registrarUsuario(@RequestBody Usuario usuario) {
    Usuario nuevoUsuario = usuarioService.registrarUsuario(usuario);
    return ResponseEntity.status(HttpStatus.CREATED).body(nuevoUsuario);
  }

  @GetMapping("/{id}")
  public ResponseEntity<Usuario> obtenerUsuario(@PathVariable Long id) {
    Usuario usuario = usuarioService.obtenerUsuarioPorId(id);
    return ResponseEntity.ok(usuario);
  }

  @PutMapping("/{id}")
  public ResponseEntity<Usuario> actualizarUsuario(@PathVariable Long id, @RequestBody Usuario usuario) {
    Usuario usuarioActualizado = usuarioService.actualizarUsuario(id, usuario);
    return ResponseEntity.ok(usuarioActualizado);
  }

  @DeleteMapping("/{id}")
  public ResponseEntity<Void> eliminarUsuario(@PathVariable Long id) {
    usuarioService.eliminarUsuario(id);
    return ResponseEntity.noContent().build();
  }
}

