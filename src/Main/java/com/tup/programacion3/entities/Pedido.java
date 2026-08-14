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

    public Pedido( LocalDate fecha, Double total, FormaPago formaPago, HashSet<DetallePedido> detallePedido,int cantidad,Producto producto) {
        super();
        this.fecha = fecha;
        this.estado = Estado.pendiente;
        this.total = total;
        this.formaPago = formaPago;
        DetallePedido detalle = new DetallePedido(cantidad,producto);
        this.detallePedido.add(detalle);
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
            producto.setStock(producto.getStock() - cantidad);
            for (DetallePedido detallePedido : detallePedido) {
                if (detallePedido.getProducto().equals(producto)) {
                    detallePedido.setCantidad(detallePedido.getCantidad() + cantidad);
                    detallePedido.setSubtotal(detallePedido.getProducto().getPrecio() * detallePedido.getCantidad());
                    return;
                }
            }
            DetallePedido detalle = new DetallePedido(cantidad, producto);
            this.detallePedido.add(detalle);

        }else {
            System.out.println("No hay suficiente stock para el producto: " + producto);
        }
    }

    public void deleteDetallePedidoByProducto(Producto producto) {
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
                super.toString() +
                "fecha=" + fecha +
                ", estado=" + estado +
                ", total=" + total +
                ", formaPago=" + formaPago +
                ", detallePedido=" + detallePedido +
                '}';
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
