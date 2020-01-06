package repositories;

import models.Lista;

import javax.persistence.EntityManager;
import java.util.List;

public class ListaRepository extends BaseRepository {
    public ListaRepository(EntityManager entityManager) {
        super(entityManager, Lista.class);
    }

    public List getByNombre(String nombre) {
        return entityManager.createQuery("SELECT a FROM Lista a WHERE a.nombreLista = :nombre")
                .setParameter("nombre", nombre)
                .getResultList();
    }

    public List getAll() {
        return entityManager.createQuery("select a from Lista a")
                .getResultList();
    }
}
