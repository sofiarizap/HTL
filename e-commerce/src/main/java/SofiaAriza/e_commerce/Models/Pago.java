package SofiaAriza.e_commerce.Models;
import jakarta.persistence.*;

import java.util.Date;

@Entity
public class Pago {

  @Id
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  private Long id;

  @ManyToOne
  @JoinColumn(name = "pedido_id", nullable = false)
  private Pedido pedido;

  @Column(nullable = false)
  private String metodoPago; // Ej. "Stripe", "PayPal", "Tarjeta de Crédito"

  @Column(nullable = false)
  private String estado; // Ej. "PENDIENTE", "COMPLETADO", "FALLIDO"

  @Column(nullable = false)
  private Double monto;

  @Temporal(TemporalType.TIMESTAMP)
  private Date fechaPago;

  private String transaccionId; // ID de la transacción del proveedor de pago

  @ManyToOne
  @JoinColumn(name = "cliente_id")
  private Cliente cliente;

  public Long getId() {
    return id;
  }

  public void setId(Long id) {
    this.id = id;
  }

  public Double getMonto() {
    return monto;
  }

  public void setMonto(Double monto) {
    this.monto = monto;
  }

  public Pedido getPedido() {
    return pedido;
  }

  public void setPedido(Pedido pedido) {
    this.pedido = pedido;
  }
}

