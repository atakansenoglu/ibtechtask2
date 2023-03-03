package hibernate.dao;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.Query;

import hibernate.model.Account;

public class AccountDao implements IAccountDao {

    private EntityManager entityManager;

    public AccountDao(EntityManager entityManager) {
        this.entityManager = entityManager;
    }

    @Override
    public void save(Account account) {
        entityManager.getTransaction().begin();
        entityManager.persist(account);
        entityManager.getTransaction().commit();
    }

    @Override
    public void update(Account account) {
        entityManager.getTransaction().begin();
        entityManager.merge(account);
        entityManager.getTransaction().commit();
    }

    @Override
    public void delete(Account account) {
        entityManager.getTransaction().begin();
        entityManager.remove(account);
        entityManager.getTransaction().commit();
    }

    @Override
    public Account getById(Long id) {
        return entityManager.find(Account.class, id);
    }

    @SuppressWarnings("unchecked")
	@Override
    public List<Account> getAll() {
        Query query = entityManager.createQuery("SELECT a FROM Account a");
        return query.getResultList();
    }
}