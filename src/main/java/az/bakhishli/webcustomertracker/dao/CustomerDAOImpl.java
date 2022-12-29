package az.bakhishli.webcustomertracker.dao;

import az.bakhishli.webcustomertracker.model.Customer;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.query.Query;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Repository
public class CustomerDAOImpl implements CustomerDAO {

    @Autowired
    private SessionFactory sessionFactory;

    @Override
    @Transactional
    public List<Customer> getCustomers() {
        Session currentSession = sessionFactory.getCurrentSession();
        Query<Customer> query =
                currentSession.createQuery("from Customer order by lastName",
                        Customer.class);
        return query.getResultList();
    }

    @Override
    public void saveCustomer(Customer customer) {
        Session currentSession = sessionFactory.getCurrentSession();
        currentSession.saveOrUpdate(customer);
    }

    @Override
    public Customer getCustomerById(int customerId) {
        Session currentSession = sessionFactory.getCurrentSession();
        Query query = currentSession.createQuery("from Customer where id = :customerId");
        query.setParameter("customerId", customerId);
        return (Customer) query.uniqueResult();
    }

    @Override
    public void delete(int customerId) {
        Session currentSession = sessionFactory.getCurrentSession();
        Query query = currentSession.createQuery("delete from Customer where id = :customerId");
        query.setParameter("customerId", customerId);
        query.executeUpdate();
    }

}
