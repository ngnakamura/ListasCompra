package models;

import javax.persistence.*;
import java.io.Serializable;

@Entity
@Table(name="productos")
public class Producto implements Serializable {

    @Id
    @Column(name = "id_producto")
    @GeneratedValue(strategy = GenerationType.AUTO)
    private int idProducto;
    @Column(name = "nombre_producto")
    private String nombreProducto;
    @Column(name = "precio_producto")
    private float precioProducto;

    public Producto() {
    }

    public Producto(String nombreProducto, float precioProducto) {
        this.nombreProducto = nombreProducto;
        this.precioProducto = precioProducto;
    }

    public int getIdProducto() {
        return idProducto;
    }

    public void setIdProducto(int idProducto) {
        this.idProducto = idProducto;
    }

    public String getNombreProducto() {
        return nombreProducto;
    }

    public void setNombreProducto(String nombreProducto) {
        this.nombreProducto = nombreProducto;
    }

    public float getPrecioProducto() {
        return precioProducto;
    }

    public void setPrecioProducto(float precioProducto) {
        this.precioProducto = precioProducto;
    }

    @Override
    public String toString() {
        return "Producto{" +
                "idProducto=" + idProducto +
                ", nombreProducto='" + nombreProducto + '\'' +
                ", precioProducto=$" + precioProducto +
                '}';
    }
}
