package hibernate.dao;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.Query;

import hibernate.model.Account;
import hibernate.model.Customer;

public class CustomerDao implements ICustomerDao {

    private EntityManager entityManager;

    public CustomerDao(EntityManager entityManager) {
        this.entityManager = entityManager;
    }

    @Override
    public void save(Customer customer) {
        entityManager.getTransaction().begin();
        entityManager.persist(customer);
        entityManager.getTransaction().commit();
    }

    @Override
    public void update(Customer customer) {
        entityManager.getTransaction().begin();
        entityManager.merge(customer);
        entityManager.getTransaction().commit();
    }

    @Override
    public void delete(Customer customer) {
        entityManager.getTransaction().begin();
        entityManager.remove(customer);
        entityManager.getTransaction().commit();
    }

    @Override
    public Customer getById(long id) {
        return entityManager.find(Customer.class, id);
    }

    @SuppressWarnings("unchecked")
	@Override
    public List<Customer> getAll() {
        Query query = entityManager.createQuery("SELECT c FROM Customer c");
        return query.getResultList();
    }

    @Override
    public void addAccount(Customer customer, Account account) {
        entityManager.getTransaction().begin();
        customer.getAccounts().add(account);
        account.setCustomer(customer);
        entityManager.getTransaction().commit();
    }

    @Override
    public void removeAccount(Customer customer, Account account) {
        entityManager.getTransaction().begin();
        customer.getAccounts().remove(account);
        account.setCustomer(null);
        entityManager.getTransaction().commit();
    }
}
