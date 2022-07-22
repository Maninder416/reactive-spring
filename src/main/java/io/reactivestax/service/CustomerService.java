package io.reactivestax.service;

import io.reactivestax.dao.CustomerDao;
import io.reactivestax.dto.Customer;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import reactor.core.publisher.Flux;

import java.util.List;

@Service
public class CustomerService {

    @Autowired
    private CustomerDao customerDao;

    public List<Customer> loadAllCustomers(){
        long start= System.currentTimeMillis();
        List<Customer> customerList= customerDao.getCustomers();
        long end= System.currentTimeMillis();
        long total= end-start;
        System.out.println("total time taken: "+total);
        return customerList;
    }

    public Flux<Customer> loadAllCustomerFlux(){
        long start= System.currentTimeMillis();
        Flux<Customer> customers= customerDao.getFluxCustomers();
        long end= System.currentTimeMillis();
        System.out.println("Total execution time: "+(end-start));
        return customers;
    }
}
