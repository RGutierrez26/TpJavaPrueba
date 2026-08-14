package Main.java.com.tup.programacion3.entities;

import java.time.LocalDateTime;

public abstract class   Base {

    private Long id;
    private Boolean eliminado;
    private LocalDateTime createdAt;

    public Base(Long id,Boolean eliminado, LocalDateTime createdAt){
        this.id = id;
        this.eliminado = eliminado;
        this.createdAt = createdAt;
    }
}
