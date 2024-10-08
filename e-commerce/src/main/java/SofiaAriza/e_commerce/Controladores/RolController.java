package SofiaAriza.e_commerce.Controladores;
import SofiaAriza.e_commerce.Models.Rol;
import SofiaAriza.e_commerce.Models.Usuario;
import SofiaAriza.e_commerce.Servicios.RolService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/roles")
public class RolController {

  @Autowired
  private RolService rolService;

  @PostMapping
  public ResponseEntity<Rol> crearRol(@RequestBody Rol rol) {
    Rol nuevoRol = rolService.crearRol(rol);
    return ResponseEntity.status(HttpStatus.CREATED).body(nuevoRol);
  }

  @GetMapping
  public ResponseEntity<List<Rol>> listarRoles() {
    List<Rol> roles = rolService.listarRoles();
    return ResponseEntity.ok(roles);
  }

  @PostMapping("/{usuarioId}/asignar/{rolId}")
  public ResponseEntity<Usuario> asignarRolAUsuario(@PathVariable Long usuarioId, @PathVariable Long rolId) {
    Usuario usuario = rolService.asignarRolAUsuario(usuarioId, rolId);
    return ResponseEntity.ok(usuario);
  }
}

