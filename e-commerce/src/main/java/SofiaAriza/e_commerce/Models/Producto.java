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
    private boolean oferta;
    private boolean activo;

    @OneToMany(mappedBy = "producto", cascade = CascadeType.ALL)
    private List<ProductoPedido> productosPedidos;

    public Producto(){ }
    public Producto(String nombre, double precio, int stock, String descripcion, String imagenUrl, String ubicacion, Categoria categoria, Boolean activo, Boolean oferta) {
        this.nombre = nombre;
        this.precio = precio;
        this.stock = stock;
        this.categoria = categoria;
        this.descripcion = descripcion;
        this.imagenUrl = imagenUrl;
        this.activo = true;
        this.oferta = false;
        this.ubicacion = ubicacion;
    }

    public Long getId() {
        return id;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getUbicacion() {
        return ubicacion;
    }

    public void setUbicacion(String ubicacion) {
        this.ubicacion = ubicacion;
    }

    public int getStock() {
        return stock;
    }

    public void setStock(int stock) {
        this.stock = stock;
    }

    public String getImagenUrl() {
        return imagenUrl;
    }

    public void setImagenUrl(String imagenUrl) {
        this.imagenUrl = imagenUrl;
    }

    public Boolean getActivo() {
        return activo;
    }

    public void setActivo(Boolean activo) {
        this.activo = activo;
    }

    public Boolean getOferta() {
        return oferta;
    }

    public void setOferta(Boolean Oferta) {
        this.oferta = oferta;
    }

    public double getPrecio() {
        return precio;
    }

    public void setPrecio(double precio) {
        this.precio = precio;
    }

    public Categoria getCategoria() {
        return categoria;
    }

    public void setCategoria(Categoria categoria) {
        this.categoria = categoria;
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
