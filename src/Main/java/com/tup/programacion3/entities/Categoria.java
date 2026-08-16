package Main.java.com.tup.programacion3.entities;

import java.time.LocalDateTime;
import java.util.Objects;
import java.util.UUID;

public class Categoria extends Base {
    private String nombre;
    private String descripcion;

    public Categoria(String nombre,String descripcion){
        super();
        this.nombre=nombre;
        this.descripcion=descripcion;
    }

    @Override
    public String toString(){
        return "Categoria{" +
                "\n\tID='" + this.id + '\'' +
                ",\n\tnombre='" + this.nombre + '\'' +
                ",\n\tdescripcion='" + this.descripcion + '\'' +
                "\n}";
    }

    @Override
    public boolean equals(Object o) {
        if (o == null || getClass() != o.getClass()) return false;
        if (!super.equals(o)) return false;
        Categoria categoria = (Categoria) o;
        return Objects.equals(this.id, categoria.id);
    }

    @Override
    public int hashCode() {
        return Objects.hash(super.hashCode(), id);
    }
}
