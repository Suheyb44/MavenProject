package hiring_process.edu.thi.hipro.beans;

import java.util.List;

import hiring_process.edu.thi.hipro.Customer;
import jakarta.ejb.LocalBean;
import jakarta.ejb.Stateless;
import jakarta.persistence.EntityManager;
import jakarta.persistence.PersistenceContext;
import jakarta.persistence.TypedQuery;

/**
 * Session Bean implementation class CustomerServiceBean
 */
@Stateless
@LocalBean
public class CustomerServiceBean implements CustomerServiceBeanRemote, CustomerServiceBeanLocal {

    @PersistenceContext
    EntityManager em;
    
    /**
     * Default constructor. 
     */
    public CustomerServiceBean() {
        // TODO Auto-generated constructor stub
    }
    public Customer create(Customer customer) {
        em.persist(customer);
        return customer;
    }
    public Customer read(Long id) {
        return this.em.find(Customer.class, id);
    }

    public Customer[] search(String email) {
        List<Customer> customers = null;
        String searchEmail = (email == null || email == "") ? "%" : "%" + email + "%";

        TypedQuery<Customer> query = em.createNamedQuery(Customer.searchCustomer, Customer.class);
        query.setParameter(1, searchEmail);
        customers = query.getResultList();
        Customer[] customerArray = new Customer[customers.size()];
        customerArray = customers.toArray(customerArray);
        return customerArray;
    }
    
    public void delete(Long id) {
        Customer customer = read(id);
        if (customer != null)
            this.em.remove(customer);
    }

    public void update(Customer customer) {
        this.em.merge(customer);
    }

}
