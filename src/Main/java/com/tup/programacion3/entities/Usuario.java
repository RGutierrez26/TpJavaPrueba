package Main.java.com.tup.programacion3.entities;
import  Main.java.com.tup.programacion3.enums.Rol;

import java.time.LocalDateTime;
import java.util.Objects;

public class Usuario extends Base{

    private String nombre;
    private String apellido;
    private String mail;
    private String celular;
    private String Contraseña;
    private Rol Rol;

    public Usuario(String nombre,String apellido, String mail,String celular,String contraseña,Rol Rol){
        super();
        this.nombre=nombre;
        this.apellido=apellido;
        this.mail=mail;
        this.celular=celular;
        this.Contraseña=contraseña;
        this.Rol=Rol;

    }

    @Override
    public String toString() {
        return "Usuario{" +
                super.toString() +
                "nombre='" + nombre + '\'' +
                ", apellido='" + apellido + '\'' +
                ", mail='" + mail + '\'' +
                ", celular='" + celular + '\'' +
                ", Contraseña='" + Contraseña + '\'' +
                ", Rol=" + Rol +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (o == null || getClass() != o.getClass()) return false;
        if (!super.equals(o)) return false;
        Usuario usuario = (Usuario) o;
        return Objects.equals(this.id, usuario.id);
    }

    @Override
    public int hashCode() {
        return Objects.hash(super.hashCode(), id);
    }
}
