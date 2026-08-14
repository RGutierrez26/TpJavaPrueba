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

        // 3 Pedidos: asignar a usuarios (u1 -> 2 pedidos, u2 -> 1 pedido)
        Map<Usuario,List<Pedido>> pedidosPorUsuario = new HashMap<>();
        pedidosPorUsuario.put(u1,new ArrayList<>());
        pedidosPorUsuario.put(u2,new ArrayList<>());

        // Pedido 1 for u1
        Pedido pedido1 = new Pedido(LocalDate.now(),0.0, FormaPago.efectivo, new HashSet<>(),1,p1);
        pedido1.addDetallePedido(2,p4);
        pedido1.CalcularTotal();
        pedidosPorUsuario.get(u1).add(pedido1);

        // Pedido 2 for u1
        Pedido pedido2 = new Pedido(LocalDate.now().minusDays(1),0.0, FormaPago.tarjeta, new HashSet<>(),2,p2);
        pedido2.addDetallePedido(1,p5);
        pedido2.CalcularTotal();
        pedidosPorUsuario.get(u1).add(pedido2);

        // Pedido 3 for u2
        Pedido pedido3 = new Pedido(LocalDate.now(),0.0, FormaPago.transferencia, new HashSet<>(),3,p3);
        pedido3.addDetallePedido(1,p6);
        pedido3.CalcularTotal();
        pedidosPorUsuario.get(u2).add(pedido3);

        // 4.a Mostrar un producto por consola (usar toString)
        System.out.println("Producto de ejemplo:\n" + p1);

        // 4.b Mostrar listado de productos cargados
        System.out.println("\nListado de productos:");
        for (Producto p: productos) System.out.println(p);

        // 4.c Mostrar pedidos del usuario que más pedidos posea
        Usuario top = null; int max = -1;
        for (Map.Entry<Usuario,List<Pedido>> e: pedidosPorUsuario.entrySet()){
            if (e.getValue().size() > max){ max = e.getValue().size(); top = e.getKey(); }
        }
        System.out.println("\nUsuario con más pedidos: " + top);
        System.out.println("Pedidos de ese usuario:");
        for (Pedido ped: pedidosPorUsuario.get(top)) System.out.println(ped);

        // 5. Instanciar un producto nuevo con el mismo id que p1 y compararlo con la colección
        String idExistente = p1.getId();
        Producto duplicado = new Producto(idExistente, "Laptop-clone",1500.0,"Laptop clónica",5,"laptop2.jpg",true);

        System.out.println("\nComparando producto duplicado (mismo id) con la colección:");
        for (Producto p: productos){
            System.out.println("Comparando con producto id="+p.getId()+": " + duplicado.equals(p));
        }
    }
}
