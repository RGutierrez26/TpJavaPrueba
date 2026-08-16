package Main.java.com.tup.programacion3.entities;

import java.time.LocalDateTime;
import java.util.HashSet;
import java.util.Objects;
import java.util.Set;

public class Producto extends Base {

    private String nombre;
    private Double precio;
    private String descripcion;
    private int stock;
    private String  imagen;
    private Boolean disponible;
    private Set<Categoria> categorias;

    public Producto(String nombre, Double precio, String descripcion, int stock, String imagen, Boolean disponible) {
        super();
        this.nombre = nombre;
        this.precio = precio;
        this.descripcion = descripcion;
        this.stock = stock;
        this.imagen = imagen;
        this.disponible = disponible;

    }

    // Constructor adicional que permite establecer un id para que equals() los compare por id
    public Producto(String id, String nombre, Double precio, String descripcion, int stock, String imagen, Boolean disponible) {
        super();
        this.id = id; // id es protegido en Base
        this.nombre = nombre;
        this.precio = precio;
        this.descripcion = descripcion;
        this.stock = stock;
        this.imagen = imagen;
        this.disponible = disponible;
    }
    public Producto(Producto producto) { //constructor de copia para copiar el producto original
        super();
        this.id = producto.id; // Copiar el id del producto original
        this.nombre = producto.nombre;
        this.precio = producto.precio;
        this.descripcion = producto.descripcion;
        this.stock = producto.stock;
        this.imagen = producto.imagen;
        this.disponible = producto.disponible;
        if (producto.categorias != null) {
            this.categorias = new HashSet<>(producto.categorias); // Copiar las categorías si existen
        }
    }

    public void AgregarCategoria(Categoria categoria) {
        if (categorias == null) {
            categorias = new HashSet<>();
        }
        categorias.add(categoria);
    }

    public Double getPrecio() {
        return precio;
    }

    @Override
    public boolean equals(Object o) {
        if (o == null || getClass() != o.getClass()) return false;
        if (!super.equals(o)) return false;
        Producto producto = (Producto) o;
        return Objects.equals(this.id, producto.id);
    }

    @Override
    public int hashCode() {
        return Objects.hash(super.hashCode(), id);
    }

    @Override
    public String toString() {
        return "Producto{" +
                "\n\tID='" + this.id + '\'' +
                ",\n\tnombre='" + nombre + '\'' +
                ",\n\tprecio=" + precio +
                ",\n\tdescripcion='" + descripcion + '\'' +
                ",\n\tstock=" + stock +
                ",\n\timagen='" + imagen + '\'' +
                ",\n\tdisponible=" + disponible +
                ",\n\tcategorias=" + (categorias == null ? "[]" : categorias) +
                "\n}";
    }

    public int getStock() {
        return stock;
    }

    public void setStock(int stock) {
        this.stock = stock;
    }
}
