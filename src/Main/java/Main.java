package Main.java;

import Main.java.com.tup.programacion3.entities.Categoria;
import Main.java.com.tup.programacion3.entities.Producto;
import Main.java.com.tup.programacion3.entities.Usuario;
import Main.java.com.tup.programacion3.entities.Pedido;
import Main.java.com.tup.programacion3.entities.DetallePedido;
import Main.java.com.tup.programacion3.enums.FormaPago;
import Main.java.com.tup.programacion3.enums.Rol;

import java.time.LocalDate;
import java.util.*;

public class Main {
    public static void main(String[] args) {
        // 3 Categorías
        Categoria cat1 = new Categoria("Electrónica","Productos electrónicos");
        Categoria cat2 = new Categoria("Ropa","Prendas de vestir");
        Categoria cat3 = new Categoria("Libros","Material de lectura");

        // 10 Productos
        List<Producto> productos = new ArrayList<>();
        Producto p1 = new Producto("Laptop",1500.0,"Laptop de alta gama",10,"laptop.jpg",true);
        Producto p2 = new Producto("Camiseta",25.0,"Camiseta de algodón",50,"camiseta.jpg",true);
        Producto p3 = new Producto("Libro Java",40.0,"Aprender Java",20,"java.jpg",true);
        Producto p4 = new Producto("Auriculares",80.0,"Auriculares bluetooth",30,"aud.jpg",true);
        Producto p5 = new Producto("Mouse",20.0,"Mouse óptico",100,"mouse.jpg",true);
        Producto p6 = new Producto("Teclado",45.0,"Teclado mecánico",40,"teclado.jpg",true);
        Producto p7 = new Producto("Pantalones",60.0,"Pantalón jean",25,"pantalon.jpg",true);
        Producto p8 = new Producto("Libro DB",55.0,"Bases de datos",15,"db.jpg",true);
        Producto p9 = new Producto("Monitor",200.0,"Monitor 24\"",12,"monitor.jpg",true);
        Producto p10 = new Producto("Sudadera",40.0,"Sudadera con capucha",18,"sudadera.jpg",true);

        productos.addAll(Arrays.asList(p1,p2,p3,p4,p5,p6,p7,p8,p9,p10));

        // Asignar categorías a productos
        p1.AgregarCategoria(cat1);
        p4.AgregarCategoria(cat1);
        p9.AgregarCategoria(cat1);
        p2.AgregarCategoria(cat2);
        p7.AgregarCategoria(cat2);
        p10.AgregarCategoria(cat2);
        p3.AgregarCategoria(cat3);
        p8.AgregarCategoria(cat3);

        // 2 Usuarios
        Usuario u1 = new Usuario("Juan","Perez","juan@mail.com","123456789","pass1", Rol.usuario);
        Usuario u2 = new Usuario("Maria","Lopez","maria@mail.com","987654321","pass2", Rol.usuario);

        // Crear un pedido para el usuario 1
        Pedido pedido1 = new Pedido( FormaPago.tarjeta, 2, p1); // 2 Laptops
        pedido1.addDetallePedido(3, p5); // 3 Mouse
        pedido1.addDetallePedido(1, p3); // 1 Libro Java
        pedido1.addDetallePedido(1,p1); //3 laptos
        Pedido pedido2 = new Pedido( FormaPago.efectivo, 1, p2); // 1 Camiseta
        pedido2.addDetallePedido(2, p7); // 2 Pantalones
        pedido2.addDetallePedido(1, p8);
        Pedido pedido3 = new Pedido( FormaPago.efectivo, 1, p3);
        pedido3.addDetallePedido(2, p10);

        u1.AgregarPedido(pedido1);
        u2.AgregarPedido(pedido2);
        u1.AgregarPedido(pedido3);

        // mostrar un producto y el catalogo
        System.out.println(p1.toString());
        System.out.println("Catálogo de productos:");
        for (Producto producto : productos) {
            System.out.println(producto.toString());
        }
        //mostrar pedidos del usuario con mas pedidos
        System.out.println( "Pedidos del usuario 1 "+ u1.toString());

        Producto productoCopia =new Producto(p1); // Crear una copia del producto p1
        for(Producto producto : productos){
            if(producto.equals(productoCopia)){
                System.out.println("El producto es igual a la copia del producto ");
            }else{
                System.out.println("El producto es diferente a la copia del producto ");
            }
        }


    }
}
