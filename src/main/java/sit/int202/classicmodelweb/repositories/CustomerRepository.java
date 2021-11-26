package sit.int202.classicmodelweb.repositories;

import jakarta.persistence.EntityManager;
import jakarta.persistence.Query;
import sit.int202.classicmodelweb.entities.Customer;
import sit.int202.classicmodelweb.entities.Office;

import java.util.List;

public class CustomerRepository {
    private EntityManager getEntityManager() {
        return EntityManagerService.getEnityManager();
    }

    private static final String FIND_USER =
            "SELECT c FROM Customer c WHERE concat(trim(c.contactFirstName), ' ', trim(c.contactLastName)) = :user_account" ;
    public Customer findByName(String name) {
        EntityManager em = getEntityManager();
        Query query = em.createQuery(FIND_USER);
        query.setParameter("user_account", name);
        List<Customer> customers = query.getResultList();
        em.close();
        return customers.size()==0? null : customers.get(0);
    }

    public void save(Customer customer) {
        EntityManager em = getEntityManager();
        em.getTransaction().begin();
        em.persist(customer);
        em.getTransaction().commit();
        em.close();
    }

    public void update(Customer customer) {
        EntityManager em =getEntityManager();
        em.getTransaction().begin();
        em.merge(customer);
        em.getTransaction().commit();
        em.close();
    }
}
