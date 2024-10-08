package SofiaAriza.e_commerce.Models;
import SofiaAriza.e_commerce.Models.Producto;
import SofiaAriza.e_commerce.Models.CarritoCompra;
import jakarta.persistence.*;

@Entity
@Table(name = "item_carrito")
public class ItemCarrito {

  @Id
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  private Long id;

  @ManyToOne
  @JoinColumn(name = "carrito_compra_id", referencedColumnName = "id")
  private CarritoCompra carritoCompra;

  @ManyToOne
  @JoinColumn(name = "producto_id", referencedColumnName = "id")
  private Producto producto;

  @Column(name = "cantidad")
  private int cantidad;

  // Constructores, Getters y Setters
  public ItemCarrito() {}

  public ItemCarrito(Producto producto, int cantidad) {
    this.producto = producto;
    this.cantidad = cantidad;
  }

  public Long getId() {
    return id;
  }

  public void setId(Long id) {
    this.id = id;
  }

  public CarritoCompra getCarritoCompra() {
    return carritoCompra;
  }

  public void setCarritoCompra(CarritoCompra carritoCompra) {
    this.carritoCompra = carritoCompra;
  }

  public Producto getProducto() {
    return producto;
  }

  public void setProducto(Producto producto) {
    this.producto = producto;
  }

  public int getCantidad() {
    return cantidad;
  }

  public void setCantidad(int cantidad) {
    this.cantidad = cantidad;
  }
}

