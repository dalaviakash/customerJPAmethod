package org.jspider.customerJPAmethod.controller;

import org.jspider.customerJPAmethod.method.Customer;
import org.jspider.customerJPAmethod.service.CustomerServices;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class CustomerController {
    @Autowired
    private CustomerServices services;
    //add customer
@PostMapping("/add")
     public void addCustomer(@RequestBody Customer c){
         services.addCustomer(c);
     }

     //get all customers
    @GetMapping("/get")
    public List<Customer>getAllCustomers(){
     return services.getAllCustomers();
    }

    //get customer by id
    @GetMapping("/getbyId")
    public Customer getCustomerById(@RequestParam int id){
    return services.getCustomerById(id);

    }
    //get customer by name
    @GetMapping("/getbyName")
    public List<Customer> getCustomerByName(@RequestParam String name){
    return services.getCustomerByName(name);
    }

    //get customer by email
    @GetMapping("/getbyEmail")
    public Customer getCustomerByEmail(@RequestParam String email){
        return services.getCustomerByEmail(email);
    }

    //get customer age
    @GetMapping("/getAge")
    public List<Customer>getCustomerAge(@RequestParam int age){
    return services.getCustomerAge(age);
    }

    //get customer Ammounts
 @GetMapping("/getAmt")
    public List<Customer>getPurchaseAmmount(@RequestParam double amt){
    return services.getPurchaseAmmount(amt);
    }

    //get customer by appliying filter
@GetMapping("/getNameAge")
    public Customer getCustomerNameandAge( String name,int age){
    return services.getCustomerNameandAge(name, age);
    }

    //get customer using conditions
@GetMapping("/agebetween")
    public List<Customer> getAgeBetween(int age1,int age2){
    return services.getAgeBetween(age1,age2);
}
//get customer name only
@GetMapping("/Customer1")
public List<Customer>getViewCustomer(String name){
    return services.viewCustomers(name);
}

//get customer age and amt

@GetMapping("/customer2")
public List<String>getAgeAmt(int age,double amt){
    return services.viewAgeAmt(age,amt);
}

//get customer using like operator
@GetMapping("/customer3")
public List<String>showCustomer(String name){
    return services.showCustomer(name);
}

//get customer using like operator
    @GetMapping("/customer4")
   public List<String>startCustomer(String name){
       return services.startCustomer(name);
   }
   //get customer using like operator
    @GetMapping("/customer5")
    public List<String>endCustomer(String name){
    return services.endCustomer(name);
    }
}
