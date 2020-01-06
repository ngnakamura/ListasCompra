package repositories;

import models.Usuario;

import javax.persistence.EntityManager;
import java.util.List;

public class UsuarioRepository extends BaseRepository{

    public UsuarioRepository(EntityManager entityManager) {
        super(entityManager, Usuario.class);
    }

    public List getByEmail(String email) {
        return entityManager.createQuery("SELECT a FROM Usuario a WHERE a.email = :email")
                .setParameter("email", email)
                .getResultList();
    }

    public List getAll() {
        return entityManager.createQuery("SELECT a FROM Usuario a").getResultList();
    }
}
