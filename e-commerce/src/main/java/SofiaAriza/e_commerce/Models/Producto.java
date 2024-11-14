package SofiaAriza.e_commerce.Models;
import jakarta.persistence.*;

import java.util.List;


@Entity
public class Producto {
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "native")
    @SequenceGenerator(name = "native", sequenceName = "native")
    private long id;
    private String nombre;
    private double precio;
    private int stock;

    private String descripcion;
    private String imagenUrl;
    private String ubicacion;
    private Categoria categoria;

    private boolean activo;

    @OneToMany(mappedBy = "producto", cascade = CascadeType.ALL)
    private List<ProductoPedido> productosPedidos;

    public Producto(){ }
    public Producto(String nombre, double precio, int stock, String descripcion, String imagenUrl, String ubicacion, Categoria categoria) {
        this.nombre = nombre;
        this.precio = precio;
        this.stock = stock;
        this.categoria = categoria;
        this.descripcion = descripcion;
        this.imagenUrl = imagenUrl;
        this.activo = true;
        this.ubicacion = ubicacion;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public double getPrecio() {
        return precio;
    }

    public void setPrecio(double precio) {
        this.precio = precio;
    }

    public String getDescripcion() {
        return descripcion;
    }

    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }

    public List<ProductoPedido> getProductosPedidos() {
        return productosPedidos;
    }

    public void setProductosPedidos(List<ProductoPedido> productosPedidos) {
        this.productosPedidos = productosPedidos;
    }

}
