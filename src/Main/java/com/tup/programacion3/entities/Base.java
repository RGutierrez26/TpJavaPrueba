package Main.java.com.tup.programacion3.entities;

import java.time.LocalDateTime;
import java.util.Objects;
import java.util.UUID;

import java.time.LocalDate;
public abstract class   Base {

    protected String id;
    private Boolean eliminado;
    private LocalDateTime createdAt;

    public Base(){
        this.id = UUID.randomUUID().toString();
        this.eliminado = false;
        this.createdAt = LocalDateTime.now();
    }

    @Override
    public String toString(){
        return "ID: "+this.id;
    }

    public Boolean getEliminado() {
        return eliminado;
    }

    public LocalDateTime getCreatedAt() {
        return createdAt;
    }

    public String getId() {
        return id;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;

        if (o == null || getClass() != o.getClass()) return false;
        Base base = (Base) o;
        return Objects.equals(id, base.id);
    }

    @Override
    public int hashCode() {
        return Objects.hashCode(id);
    }

}
