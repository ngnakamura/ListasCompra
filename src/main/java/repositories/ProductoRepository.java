package repositories;

import models.Producto;

import javax.persistence.EntityManager;
import java.util.List;

public class ProductoRepository extends BaseRepository{

    public ProductoRepository(EntityManager entityManager) {
        super(entityManager, Producto.class);
    }

    public List getByNombre(String nombre) {
        return entityManager.createQuery("SELECT a FROM Producto a WHERE a.nombreProducto = :nombre")
                .setParameter("nombre", nombre)
                .getResultList();
    }

    public List getByPrecio(float precio) {
        return entityManager.createQuery("SELECT a FROM Producto a WHERE a.precioProducto = :precio")
                .setParameter("precio", precio)
                .getResultList();
    }

    public List getAll() {
        return entityManager.createQuery("SELECT a FROM Producto a").getResultList();
    }
}
