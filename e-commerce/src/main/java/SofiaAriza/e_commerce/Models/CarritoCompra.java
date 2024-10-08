package SofiaAriza.e_commerce.Models;
import jakarta.persistence.*;
import java.util.List;

@Entity
@Table(name = "carrito_compras")
public class CarritoCompra {

  @Id
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  private Long id;

  @OneToOne
  @JoinColumn(name = "cliente_id", referencedColumnName = "id")
  private Cliente cliente;

  @OneToMany(mappedBy = "carritoCompra", cascade = CascadeType.ALL, fetch = FetchType.LAZY)
  private List<ItemCarrito> items;

  @Column(name = "total")
  private Double total;

  // Constructores
  public CarritoCompra() {}

  public CarritoCompra(Cliente cliente) {
    this.cliente = cliente;
  }

  // Getters y Setters
  public Long getId() {
    return id;
  }

  public void setId(Long id) {
    this.id = id;
  }

  public Cliente getCliente() {
    return cliente;
  }

  public void setCliente(Cliente cliente) {
    this.cliente = cliente;
  }

  public List<ItemCarrito> getItems() {
    return items;
  }

  public void setItems(List<ItemCarrito> items) {
    this.items = items;
  }

  public Double getTotal() {
    return total;
  }

  public void setTotal(Double total) {
    this.total = total;
  }

  // Método para calcular el total del carrito
  public void calcularTotal() {
    total = items.stream()
            .mapToDouble(item -> item.getCantidad() * item.getProducto().getPrecio())
            .sum();
  }

  // Método para agregar un item al carrito
  public void agregarItem(ItemCarrito item) {
    items.add(item);
    item.setCarritoCompra(this);  // Establece la relación bidireccional
    calcularTotal();
  }

  // Método para eliminar un item del carrito
  public void eliminarItem(ItemCarrito item) {
    items.remove(item);
    calcularTotal();
  }
}


