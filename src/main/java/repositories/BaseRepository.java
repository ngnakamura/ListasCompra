package repositories;

import javax.persistence.EntityManager;
import java.util.List;

public abstract class BaseRepository<E> {

    protected EntityManager entityManager;
    private Class clazz;

    public BaseRepository(EntityManager entityManager, Class clazz) {
        this.entityManager = entityManager;
        this.clazz = clazz;
    }

    public void save(E e) {
        if(e==null) return;
        entityManager.getTransaction().begin();
        entityManager.persist(e);
        entityManager.getTransaction().commit();
    }

    public void update(E e) {
        if(e == null) return;
        entityManager.getTransaction().begin();
        entityManager.merge(e);
        entityManager.getTransaction().commit();
    }

    public void remove(E e) {
        if(e == null) return;
        entityManager.getTransaction().begin();
        entityManager.remove(e);
        entityManager.getTransaction().commit();
    }

    public E getById(int id) {
        return (E)entityManager.find(clazz, id);
    }
}
