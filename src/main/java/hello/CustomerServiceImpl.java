package hello;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * @author jsingh on 2/22/2014
 */
@Service
public class CustomerServiceImpl implements CustomerService {

    @Autowired
    CustomerRepository repository;

    @Override
    public Customer save(Customer customer) {
        return repository.save(customer);
    }

    @Override
    public long count() {
        return repository.count();
    }

    @Override
    public Iterable<Customer> findAll() {
        return  repository.findAll();
    }

    @Override
    public Customer findOne(Long id) {
        return repository.findOne(id);
    }

    @Override
    public List<Customer> findByLastName(String lastName) {
        return repository.findByLastName(lastName);
    }
}
