package Main.java.com.tup.programacion3.entities;
import  Main.java.com.tup.programacion3.enums.Rol;

import java.time.LocalDateTime;

public class Usuario extends Base{

    private String nombre;
    private String apellido;
    private String mail;
    private String celular;
    private String Contraseña;
    private Rol Rol;

    public Usuario(Long id,Boolean eliminado, LocalDateTime createdAt,String nombre,String apellido, String mail,String celular,String contraseña,Rol Rol){
        super(id,eliminado,createdAt);
        this.nombre=nombre;
        this.apellido=apellido;
        this.mail=mail;
        this.celular=celular;
        this.Contraseña=contraseña;
        this.Rol=Rol;

    }

}
