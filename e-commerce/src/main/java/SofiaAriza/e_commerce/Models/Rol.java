package SofiaAriza.e_commerce.Models;
import jakarta.persistence.*;

import java.util.Set;

@Entity
public class Rol {

  @Id
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  private Long id;

  private String nombre;

  @ManyToMany(mappedBy = "roles")
  private Set<Usuario> usuarios;

  // Constructor
  public Rol() {}

  public Rol(String nombre) {
    this.nombre = nombre;
  }

  // Getters y Setters
  public Long getId() {
    return id;
  }

  public void setId(Long id) {
    this.id = id;
  }

  public String getNombre() {
    return nombre;
  }

  public void setNombre(String nombre) {
    this.nombre = nombre;
  }

  public Set<Usuario> getUsuarios() {
    return usuarios;
  }

  public void setUsuarios(Set<Usuario> usuarios) {
    this.usuarios = usuarios;
  }
}

