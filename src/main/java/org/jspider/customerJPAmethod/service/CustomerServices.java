package org.jspider.customerJPAmethod.service;

import org.aspectj.weaver.ast.And;
import org.jspider.customerJPAmethod.method.Customer;
import org.jspider.customerJPAmethod.repository.CustomerRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.GetMapping;

import java.util.ArrayList;
import java.util.List;

@Service
public class CustomerServices {
    List<Customer> customerList = new ArrayList<>();
    @Autowired
    private CustomerRepository repository;

    public void addCustomer(Customer c){
        repository.save(c);
    }

    //get all customers
    public List<Customer>getAllCustomers(){
        List<Customer>customerList=repository.findAll();
        return customerList;
    }
//get customer by id
    public Customer getCustomerById(int id){
        return repository.findById(id).orElse(null);

    }

    //get customer by name
    public List<Customer>getCustomerByName(String name){
        return repository.findByCustomerName(name);
    }


    //get customer by EmAIL

    public  Customer getCustomerByEmail(String email){
        return repository.findByCustomerEmail(email);
    }

    //get customer age greter than given value
    public List<Customer>getCustomerAge(int age){
        return repository.findByCustomerAgeGreaterThan(age);
    }

    //get customer purchase value is less trahn given value

    public List<Customer>getPurchaseAmmount(double amt){
        return repository.findByTotalPerchaseLessThan(amt);
    }

    public Customer getCustomerNameandAge(String name,int age){
        return repository.findByCustomerNameAndCustomerAge(name, age);
    }

    public List<Customer> getAgeBetween(int age1,int age2){
        return repository.findByCustomerAgeBetween(age1,age2);
    }

    public List<Customer>viewCustomers(String name){
        return repository.viewCustomers(name);
    }

    public List<String>viewAgeAmt(int age,double amt){
        return repository.viewAgeAmt(age,amt);
    }

    public  List<String>showCustomer(String name){
        return  repository.showCharachter(name);
    }

    public  List<String>startCustomer(String name){
        return  repository.viewCharachter(name);
    }

    public List<String>endCustomer(String name){
        return repository.endCharachter(name);
    }

}
