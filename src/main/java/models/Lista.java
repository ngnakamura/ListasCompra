package models;

import javax.persistence.*;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

@Entity
@Table(name = "listas")
public class Lista implements Serializable {

    @Id
    @Column(name = "id_lista")
    @GeneratedValue(strategy = GenerationType.AUTO)
    private int idLista;
    @Column(name = "nombre_lista")
    private String nombreLista;
    @OneToMany(mappedBy = "pk.lista")
    private List<ItemLista> items = new ArrayList<ItemLista>();
    @ManyToOne
    private Usuario usuario;

    public Lista() {
    }

    public Lista(String nombreLista) {
        this.nombreLista = nombreLista;
    }

    public int getIdLista() {
        return idLista;
    }

    public void setIdLista(int idLista) {
        this.idLista = idLista;
    }

    public String getNombreLista() {
        return nombreLista;
    }

    public void setNombreLista(String nombreLista) {
        this.nombreLista = nombreLista;
    }

    public List<ItemLista> getItems() {
        return items;
    }

    public void setItems(List<ItemLista> items) {
        this.items = items;
    }

    public Usuario getUsuario() {
        return usuario;
    }

    public void setUsuario(Usuario usuario) {
        this.usuario = usuario;
    }

    @Override
    public String toString() {
        return "Lista{" +
                "idLista=" + idLista +
                ", nombreLista='" + nombreLista + '\'' +
                ", items=" + items +
                ", usuario=" + usuario +
                '}';
    }
}
