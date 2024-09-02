package SofiaAriza.e_commerce.Models;
import jakarta.persistence.*;


@Entity
public class Cliente {
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "native")
    @SequenceGenerator(name = "native", sequenceName = "native")
    private long id;
    private String nombre;
    private String direccion;
    private String ciudad;
    private String email;
    private String clave;
    private String telefono;
    private Carrito carrito;


    public Cliente(){ }
    public Cliente(String nombre, String direccion, String ciudad, String email, String clave, String telefono, Carrito carrito) {
        this.nombre = nombre;
        this.direccion = direccion;
        this.email = email;
        this.clave = clave;
        this.telefono = telefono;
        this.ciudad = ciudad;
        this.carrito = carrito;
    }
    public Long getId(){return id;}

    public String getEmail(){
        return email;
    }

    public void setEmail(String Email){
        this.email = Email;
    }

    public String getNombre(){
        return nombre;
    }
    public void setNombre(String nombre){
        this.nombre = nombre;
    }

    public String getClave() { return clave;}

    public void setPassword(String password) { this.clave = password;}



}