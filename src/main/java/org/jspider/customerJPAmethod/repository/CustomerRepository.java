package org.jspider.customerJPAmethod.repository;

import org.aspectj.weaver.ast.And;
import org.jspider.customerJPAmethod.method.Customer;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface CustomerRepository extends JpaRepository<Customer,Integer> {
    Customer findByCustomerId(int id);
    //return list of all customers having specific name
    List<Customer>findByCustomerName(String name);

    //return list of all customers having specific email
    Customer findByCustomerEmail(String email);

    //return list of customer having age greater than
    List<Customer>findByCustomerAgeGreaterThan(int age);

    //return list of customer having purchase ammount less than

    List<Customer>findByTotalPerchaseLessThan(double amt);

    //return list of customer having name=? and age=?

    Customer findByCustomerNameAndCustomerAge(String name,int age);

    //return list of customer having  age between ? and ?

    List<Customer> findByCustomerAgeBetween(int age1,int age2);

    //writing JPQL
    //write JPQL to fetch customer by name
    @Query("select c from Customer c where c.customerName=:name")
    List<Customer>viewCustomers(@Param("name") String name);

    //write JPQL to fetch customer names having age<? and amt>=?
    @Query("select c.customerName from Customer c where c.customerAge<:age and c.totalPerchase>=:amt")
    List<String>viewAgeAmt(@Param("age") int age,@Param("amt") double amt);

    ///fetch chracters
    @Query("select c.customerName from Customer c where c.customerName like %:name%")
    List<String>showCharachter(@Param("name")String name);

    //write JPQL to fetch customer name strats with spwcific character
   @Query("select c.customerName from Customer c where c.customerName like :name%")
   List<String>viewCharachter(String name);

    //write JPQL to fetch customer name ends with spwcific character
    @Query("select c.customerName from Customer c where c.customerName like %:name")
    List<String>endCharachter(@Param("name")String name);

}
