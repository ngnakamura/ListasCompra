package models;

import javax.persistence.Embeddable;
import javax.persistence.ManyToOne;
import java.io.Serializable;

@Embeddable
public class ListaItemId implements Serializable {

    @ManyToOne
    private Lista lista;
    @ManyToOne
    private Producto producto;

    public Lista getLista() {
        return lista;
    }

    public void setLista(Lista lista) {
        this.lista = lista;
    }

    public Producto getProducto() {
        return producto;
    }

    public void setProducto(Producto producto) {
        this.producto = producto;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        ListaItemId that = (ListaItemId) o;
        if (lista != null ? !lista.equals(that.lista) : that.lista != null) return false;
        if (producto != null ? !producto.equals(that.producto) : that.producto != null)
            return false;

        return true;
    }

    @Override
    public int hashCode() {
        int result;
        result = (lista != null ? lista.hashCode() : 0);
        result = 31 * result + (producto != null ? producto.hashCode() : 0);
        return result;
    }

    @Override
    public String toString() {
        return "ListaItemId{" +
                "lista=" + lista.getNombreLista() +
                ", producto=" + producto.getNombreProducto() +
                '}';
    }
}
