package com.example.demo.service;

import com.example.demo.dao.CustomerDAO;
import com.example.demo.exception.CustomerNotFoundException;
import com.example.demo.model.Customer;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.Optional;
import java.util.concurrent.CopyOnWriteArrayList;

@Component
public class CustomerService {

    @Autowired
    private CustomerDAO customerDao;

//    int customerIdCount = 1;
    private List<Customer> customerList = new CopyOnWriteArrayList<>();

    public Customer addCustomer(Customer customer)
    {
//        customer.setCustomerId(customerIdCount);
//        customerList.add(customer);
//        customerList.add(customer);
//        customerIdCount++;

        return customerDao.save(customer);
       // return customer;
    }

    public List<Customer> getCustomer()
    {

        return customerDao.findAll();
//        return  customerList;
    }

    public Customer getCustomer(int customerid)
    {
        Optional<Customer> optionalCustomer = customerDao.findById(customerid);
        if(!optionalCustomer.isPresent())
        {
            throw new CustomerNotFoundException("Customer Record is not available");
        }
//        return customerList.stream().filter(c -> c.getCustomerId() == customerid).findFirst().get();
        return customerDao.findById(customerid).get();
    }

    public Customer updateCustomer (int customerid, Customer customer)
    {
        customer.setCustomerId(customerid);
//        customerList.stream().forEach(c ->  {
//            if(c.getCustomerId() == customerid)
//            {
//                c.setFirstName(customer.getFirstName());
//                c.setLastName(customer.getLastName());
//                c.setCustomerEmail(customer.getCustomerEmail());
//            }
//        });
//                return customerList.stream().filter(c -> customer.getCustomerId() == customerid).findFirst().get();

       return customerDao.save(customer);


    }

    public void deleteCustomer(int customerid)
    {
//        customerList.stream().forEach(c ->{
//            if(c.getCustomerId() == customerid)
//            {
//                customerList.remove(c);
//            }
//        });

        customerDao.deleteById(customerid);
    }
}

