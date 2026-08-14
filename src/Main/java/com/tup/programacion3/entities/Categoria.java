package Main.java.com.tup.programacion3.entities;

import java.time.LocalDateTime;

public class Categoria extends Base {
    private String nombre;
    private String descripcion;

    public Categoria(Long id,Boolean eliminado, LocalDateTime createdAt,String nombre,String descripcion){
        super(id,eliminado,createdAt);
        this.nombre=nombre;
        this.descripcion=descripcion;
    }
}
