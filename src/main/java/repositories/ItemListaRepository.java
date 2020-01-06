package repositories;

import models.ItemLista;

import javax.persistence.EntityManager;
import java.util.List;

public class ItemListaRepository extends BaseRepository {
    public ItemListaRepository(EntityManager entityManager) {
        super(entityManager, ItemLista.class);
    }

    public List getAllByListaId(int idLista) {
        return entityManager.createQuery("SELECT a FROM ItemLista a WHERE a.pk.lista.id = :idLista")
                .setParameter("idLista", idLista)
                .getResultList();
    }
}
