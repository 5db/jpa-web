package hello;

import java.util.List;

/**
 * @author jsingh on 2/22/2014
 */
public interface CustomerService {

    Customer save(Customer customer);

    long count();

    Iterable<Customer> findAll();

    Customer findOne(Long id);

    List<Customer> findByLastName(String lastName);
}
