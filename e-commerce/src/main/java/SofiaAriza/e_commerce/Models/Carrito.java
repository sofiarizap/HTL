package SofiaAriza.e_commerce.Models;

import jakarta.persistence.*;

@Entity
public class Carrito {

        @Id
        @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "cliente_seq")
        @SequenceGenerator(name = "cliente_seq", sequenceName = "cliente_id_seq", allocationSize = 1)
        private long id;
        private Cliente cliente;
        private Producto producto;
        private String ciudad;
        private String email;
        private String clave;
        private String telefono;


        public Carrito(String nombre, String direccion, String ciudad, String email, String clave, String telefono, Carrito carrito) {
            this.email = email;
            this.clave = clave;
            this.telefono = telefono;
            this.ciudad = ciudad;

        }
}
