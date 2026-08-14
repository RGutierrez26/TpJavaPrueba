package Main.java.com.tup.programacion3.entities;

import java.time.LocalDateTime;
import java.util.Objects;

public class DetallePedido extends Base{

    private int Cantidad;
    private Double Subtotal;
    private Producto producto;

    public DetallePedido(int Cantidad,Producto producto){
        super();
        this.Cantidad=Cantidad;
        this.Subtotal=producto.getPrecio()*Cantidad;
        this.producto=producto;
    }

    @Override
    public String toString() {
        return "DetallePedido{" +
                super.toString() +
                "Cantidad=" + Cantidad +
                ", Subtotal=" + Subtotal +
                ", producto=" + producto +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (o == null || getClass() != o.getClass()) return false;
        if (!super.equals(o)) return false;
        DetallePedido that = (DetallePedido) o;
        return this.id == that.id;
    }

    @Override
    public int hashCode() {
        return Objects.hash(super.hashCode(), this.id);
    }

    public int getCantidad() {
        return Cantidad;
    }

    public void setCantidad(int cantidad) {
        Cantidad = cantidad;
    }

    public Double getSubtotal() {
        return Subtotal;
    }

    public void setSubtotal(Double subtotal) {
        Subtotal = subtotal;
    }

    public Producto getProducto() {
        return producto;
    }

    public void setProducto(Producto producto) {
        this.producto = producto;
    }
}
