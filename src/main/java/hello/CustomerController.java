package hello;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.List;

/**
 * @author jsingh on 2/22/2014
 */
@Controller
public class CustomerController {

    @Autowired
    CustomerService service;

    @RequestMapping(value = "/greeting", method = RequestMethod.GET)
    public @ResponseBody Customer greeting() {
        Customer customer = new Customer("Jatinder", "Singh");
        service.save(customer);
        return customer;
    }

    @RequestMapping(value = "/count", method = RequestMethod.GET)
    public @ResponseBody Long count() {
        return service.count();
    }

    @RequestMapping(value = "/beacon", method = RequestMethod.GET)
    public @ResponseBody String beacon() {
        return "I'm Alive";
    }

    @RequestMapping(value = "/all", method = RequestMethod.GET)
    public @ResponseBody Iterable<Customer> all() {
        return service.findAll();
    }

    @RequestMapping(value = "/one", method = RequestMethod.GET)
    public @ResponseBody Customer findOne() {
        Customer customer = service.findOne(5l);
        System.out.println("Customer Name: " + customer.getFirstName() + ", " + customer.getLastName());
        return customer;
    }

    @RequestMapping(value = "/name", method = RequestMethod.GET)
    public @ResponseBody List<Customer> findByLastName() {
        return service.findByLastName("Bauer");
    }
}
