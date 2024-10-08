package SofiaAriza.e_commerce.Models;
import jakarta.persistence.*;
import java.util.List;

@Entity
public class Pedido {

  @Id
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  private Long id;

  @ManyToOne
  @JoinColumn(name = "cliente_id", nullable = false)
  private Cliente cliente;

  @OneToMany(mappedBy = "pedido", cascade = CascadeType.ALL)
  private List<ProductoPedido> productosPedidos;

  private double total;

  // Constructor
  public Pedido() {}

  public Pedido(Cliente cliente, List<ProductoPedido> productosPedidos, double total) {
    this.cliente = cliente;
    this.productosPedidos = productosPedidos;
    this.total = total;
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

  public List<ProductoPedido> getProductosPedidos() {
    return productosPedidos;
  }

  public void setProductosPedidos(List<ProductoPedido> productosPedidos) {
    this.productosPedidos = productosPedidos;
  }

  public double getTotal() {
    return total;
  }

  public void setTotal(double total) {
    this.total = total;
  }
}
