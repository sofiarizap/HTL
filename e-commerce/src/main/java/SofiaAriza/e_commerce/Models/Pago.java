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

  // Getters y Setters
}

