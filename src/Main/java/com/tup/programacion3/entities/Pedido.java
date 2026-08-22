package Main.java.com.tup.programacion3.entities;

import Main.java.com.tup.programacion3.enums.Estado;
import Main.java.com.tup.programacion3.enums.FormaPago;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.HashSet;
import java.util.Objects;
import java.util.Set;

public class Pedido extends Base implements Calculable  {

    private LocalDate fecha;
    private Estado estado;
    private Double total;
    private FormaPago formaPago;
    private Set<DetallePedido> detallePedido = new HashSet<>();

    public Pedido(FormaPago formaPago,int cantidad,Producto producto) {
        super();
        this.fecha = LocalDate.now();
        this.estado = Estado.pendiente;
        this.formaPago = formaPago;
        DetallePedido detalle = new DetallePedido(cantidad,producto);
        this.detallePedido.add(detalle);
        this.total=detalle.getSubtotal();
    }

    @Override
    public void CalcularTotal() {

        double total = 0.0;
        for (DetallePedido detalle : detallePedido) {
            total += detalle.getSubtotal();
        }
        this.total = total;

    }

    public void addDetallePedido(int cantidad,Producto producto){

        if (producto.getStock() > cantidad) {
            producto.setStock(producto.getStock() - cantidad); //restar stock
            DetallePedido detalleBuscado = this.findeDetallePedidoByProducto(producto); //busca si ya existe el producto en el set
                if (detalleBuscado != null) {
                    detalleBuscado.setCantidad(detalleBuscado.getCantidad() + cantidad); //agrega cantidad
                    detalleBuscado.setSubtotal(detalleBuscado.getProducto().getPrecio() * detalleBuscado.getCantidad()); //suma subtotal

                }else{
                    DetallePedido detalle = new DetallePedido(cantidad, producto);
                    this.detallePedido.add(detalle);
                }
            }
        else {
            System.out.println("No hay suficiente stock para el producto: " + producto);
            return;
        }
        this.CalcularTotal();
    }

    public void deleteDetallePedidoByProducto(Producto producto) {
        for(DetallePedido detalle : detallePedido) {
            if (detalle.getProducto().equals(producto)) {
                producto.setStock(producto.getStock() + detalle.getCantidad()); //sumar stock
                total=total-detalle.getSubtotal(); //resta total
                break;
            }
        }
        detallePedido.removeIf(detalle -> detalle.getProducto().equals(producto));

    }

    public DetallePedido findeDetallePedidoByProducto(Producto producto) {

        for (DetallePedido detalle : detallePedido) {
            if (detalle.getProducto().equals(producto)) {
                return detalle;
            }
        }
        return null;
    }


    @Override
    public String toString() {
        return "Pedido{" +
                "\n\tID='" + this.id + '\'' +
                ",\n\tfecha=" + fecha +
                ",\n\testado=" + estado +
                ",\n\ttotal=" + total +
                ",\n\tformaPago=" + formaPago +
                ",\n\t............................" +
                ",\n\tdetallePedido=" + (detallePedido == null ? "[]" : detallePedido) +
                "\n}";
    }

    @Override
    public boolean equals(Object o) {
        if (o == null || getClass() != o.getClass()) return false;
        if (!super.equals(o)) return false;
        Pedido pedido = (Pedido) o;
        return Objects.equals(this.id, pedido.id);
    }

    @Override
    public int hashCode() {
        return Objects.hash(super.hashCode(), this.id);
    }


}
