package models;

import javax.persistence.*;
import java.io.Serializable;

@Entity
@Table(name = "item_lista")
@AssociationOverrides({
        @AssociationOverride( name = "pk.lista",
            joinColumns = @JoinColumn( name = "id_lista")),
        @AssociationOverride( name = "pk.producto",
            joinColumns = @JoinColumn( name = "id_producto"))
})
public class ItemLista implements Serializable {

    @EmbeddedId
    private ListaItemId pk = new ListaItemId();
    @Column(name = "cantidad")
    private int cantidad;

    public ItemLista() {
    }

    public ListaItemId getPk() {
        return pk;
    }

    public void setPk(ListaItemId pk) {
        this.pk = pk;
    }

    public int getCantidad() {
        return cantidad;
    }

    public void setCantidad(int cantidad) {
        this.cantidad = cantidad;
    }

    @Transient
    public Lista getLista() {
        return getPk().getLista();
    }

    public void setLista(Lista lista) {
        getPk().setLista(lista);
    }

    @Transient
    public Producto getProducto () {
        return getPk().getProducto();
    }

    public void setProducto(Producto producto) {
        getPk().setProducto(producto);
    }

    @Override
    public boolean equals(Object o) {
        if (this == o)
            return true;
        if (o == null || getClass() != o.getClass())
            return false;

        ItemLista that = (ItemLista) o;

        if (getPk() != null ? !getPk().equals(that.getPk())
                : that.getPk() != null)
            return false;

        return true;
    }

    @Override
    public int hashCode() {
        return (getPk() != null ? getPk().hashCode() : 0);
    }

    @Override
    public String toString() {
        return "ItemLista{" +
                "pk=" + pk +
                ", cantidad=" + cantidad +
                '}';
    }
}
