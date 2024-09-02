package SofiaAriza.e_commerce.Models;

import jakarta.persistence.*;

@Entity
public class Orden {
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "native")
    @SequenceGenerator(name = "native", sequenceName = "native")
    private long id;
    private Cliente cliente;
    private Producto producto;
}
