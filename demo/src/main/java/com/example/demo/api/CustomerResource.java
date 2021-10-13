package com.example.demo.api;

import com.example.demo.model.Customer;
import com.example.demo.service.CustomerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping(value = "/customers")
public class CustomerResource {

    @Autowired
    private CustomerService customerservice;

    @PostMapping
    public Customer addCustomer(@RequestBody  Customer customer)
    {
        return customerservice.addCustomer(customer);
    }
    @GetMapping
    public List<Customer> getCustomer()
    {
        return  customerservice.getCustomer();
    }
    @GetMapping(value = "/{customerId}")
    public Customer getCustomer(@PathVariable("customerId") int customerid)
    {
        return  customerservice.getCustomer(customerid);
    }

    @PutMapping(value = "/{customerId}")
    public Customer getCustomer(@PathVariable("customerId") int customerid, @RequestBody Customer customer)
    {
        return  customerservice.updateCustomer(customerid,customer);
    }

    @DeleteMapping(value = "/{customerId}")
    public void deleteCustomer(@PathVariable("customerId") int customerid)
    {
        customerservice.deleteCustomer(customerid);
    }

}
