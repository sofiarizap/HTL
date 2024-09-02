package SofiaAriza.e_commerce.Models;

import jakarta.persistence.*;

@Entity
public class Cuenta {
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "native")
    @SequenceGenerator(name = "native", sequenceName = "native")
    private long id;

}

