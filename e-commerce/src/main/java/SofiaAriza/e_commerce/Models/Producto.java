package SofiaAriza.e_commerce.Models;

import jakarta.persistence.*;

import java.util.HashSet;

@Entity
public class Producto {
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "producto_seq")
    @SequenceGenerator(name = "producto_seq", sequenceName = "producto_id_seq", allocationSize = 1)
    private long id;
    private String nombre;
    private double precio;
    private int stock;
    @Lob
    private String descripcion;
    private String imagenUrl;
    private String ubicacion;

    private boolean activo;

    public Producto(String nombre, double precio, int stock, String descripcion, String imagenUrl, String ubicacion) {
        this.nombre = nombre;
        this.precio = precio;
        this.stock = stock;
        this.descripcion = descripcion;
        this.imagenUrl = imagenUrl;
        this.activo = true;
        this.ubicacion = ubicacion;
    }
}
