package ibtech.training.dao;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.Query;

import ibtech.training.model.AccountModel;
import ibtech.training.model.CustomerModel;

public class CustomerDao implements ICustomerDao {

    private EntityManager entityManager;

    public CustomerDao(EntityManager entityManager) {
        this.entityManager = entityManager;
    }

    public void save(CustomerModel customer) {
        entityManager.getTransaction().begin();
        entityManager.persist(customer);
        entityManager.getTransaction().commit();
    }

    public void update(CustomerModel customer) {
        entityManager.getTransaction().begin();
        entityManager.merge(customer);
        entityManager.getTransaction().commit();
    }
    
    public void delete(CustomerModel customer) {
        entityManager.getTransaction().begin();
        entityManager.remove(customer);
        entityManager.getTransaction().commit();
    }

    public CustomerModel getById(long id) {
        return entityManager.find(CustomerModel.class, id);
    }

    @SuppressWarnings("unchecked")
	public List<CustomerModel> getAll() {
        Query query = entityManager.createQuery("SELECT c FROM CustomerModel c");
        return query.getResultList();
    }

    public void addAccount(CustomerModel customer, AccountModel account) {
        entityManager.getTransaction().begin();
        customer.getAccounts().add(account);
        account.setCustomer(customer);
        entityManager.getTransaction().commit();
    }

    public void removeAccount(CustomerModel customer, AccountModel account) {
        entityManager.getTransaction().begin();
        customer.getAccounts().remove(account);
        account.setCustomer(null);
        entityManager.getTransaction().commit();
    }
}
