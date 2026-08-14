package Main.java.com.tup.programacion3.entities;

import java.time.LocalDateTime;

public class Producto extends Base {

    private String nombre;
    private Double precio;
    private String descripcion;
    private int stock;
    private String  imagen;
    private Boolean disponible;

    public Producto(Long id, Boolean eliminado, LocalDateTime createdAt  ) {
        super(id, eliminado, createdAt);
    }
}
