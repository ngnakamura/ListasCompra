package DAOs;

import models.Producto;

import javax.persistence.EntityManager;
import javax.persistence.EntityTransaction;

public class ProductDao {

    private EntityManager entityManager;
    private EntityTransaction entityTransaction;

    public ProductDao(EntityManager entityManager) {
        this.entityManager = entityManager;
        this.entityTransaction = this.entityManager.getTransaction();
    }

    public void persist(String nombre, float precio) {
        beginTransaction();
        Producto producto = new Producto(nombre,precio);
        entityManager.persist(producto);
        commitTransaction();
    }

    public Producto find(int id) {
        return entityManager.find(Producto.class, id);
    }

    public void update(int id, String nombre, float precio) {
        beginTransaction();
        Producto producto = entityManager.find(Producto.class, id);
        producto.setNombreProducto(nombre);
        producto.setPrecioProducto(precio);
        entityManager.merge(producto);
        commitTransaction();
    }

    public void remove(int id) {
        beginTransaction();
        Producto producto = entityManager.find(Producto.class, id);
        entityManager.remove(producto);
        commitTransaction();
    }

    private void beginTransaction() {
        try {
            entityTransaction.begin();
        } catch (IllegalStateException e) {
            rollbackTransaction();
        }
    }

    private void commitTransaction() {
        try {
            entityTransaction.commit();
            entityManager.close();
        } catch (IllegalStateException e) {
            rollbackTransaction();
        }
    }

    private void rollbackTransaction() {
        try {
            entityTransaction.rollback();
        } catch (IllegalStateException e) {
            e.printStackTrace();
        }
    }
}
