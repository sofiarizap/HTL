package SofiaAriza.e_commerce.Models;

import jakarta.persistence.*;

@Entity
public class Carrito {

        @Id
        @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "native")
        @SequenceGenerator(name = "native", sequenceName = "native")
        private long id;


        private String ciudad;
        private String email;
        private String clave;
        private String telefono;

        public Carrito(){ }
        public Carrito(String nombre, String direccion, String ciudad, String email, String clave, String telefono, Carrito carrito) {
            this.email = email;
            this.clave = clave;
            this.telefono = telefono;
            this.ciudad = ciudad;

        }
}
