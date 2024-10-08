package SofiaAriza.e_commerce.Models;
import jakarta.persistence.*;

import java.util.Set;

@Entity
public class Usuario {

  @Id
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  private Long id;

  private String username;
  private String password;
  private boolean activo;

  @ManyToMany(fetch = FetchType.EAGER)
  @JoinTable(
          name = "usuario_rol",
          joinColumns = @JoinColumn(name = "usuario_id"),
          inverseJoinColumns = @JoinColumn(name = "rol_id")
  )
  private Set<Rol> roles;

  // Constructor
  public Usuario() {}

  public Usuario(String username, String password, boolean activo, Set<Rol> roles) {
    this.username = username;
    this.password = password;
    this.activo = activo;
    this.roles = roles;
  }

  // Getters y Setters
  public Long getId() {
    return id;
  }

  public void setId(Long id) {
    this.id = id;
  }

  public String getUsername() {
    return username;
  }

  public void setUsername(String username) {
    this.username = username;
  }

  public String getPassword() {
    return password;
  }

  public void setPassword(String password) {
    this.password = password;
  }

  public boolean isActivo() {
    return activo;
  }

  public void setActivo(boolean activo) {
    this.activo = activo;
  }

  public Set<Rol> getRoles() {
    return roles;
  }

  public void setRoles(Set<Rol> roles) {
    this.roles = roles;
  }
}
