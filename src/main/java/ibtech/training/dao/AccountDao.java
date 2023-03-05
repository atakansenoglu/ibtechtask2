package ibtech.training.dao;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.Query;

import ibtech.training.model.AccountModel;

public class AccountDao implements IAccountDao {

    private EntityManager entityManager;

    public AccountDao(EntityManager entityManager) {
        this.entityManager = entityManager;
    }

    public void save(AccountModel account) {
        entityManager.getTransaction().begin();
        entityManager.persist(account);
        entityManager.getTransaction().commit();
    }

    public void update(AccountModel account) {
        entityManager.getTransaction().begin();
        entityManager.merge(account);
        entityManager.getTransaction().commit();
    }

    public void delete(AccountModel account) {
        entityManager.getTransaction().begin();
        entityManager.remove(account);
        entityManager.getTransaction().commit();
    }

    public AccountModel getById(Long id) {
        return entityManager.find(AccountModel.class, id);
    }

    @SuppressWarnings("unchecked")
    public List<AccountModel> getAll() {
        Query query = entityManager.createQuery("SELECT a FROM Account a");
        return query.getResultList();
    }
}