package com.crm.siigroup.crmApp.repository;

import com.crm.siigroup.crmApp.models.entity.Customers;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
import org.springframework.stereotype.Repository;

import java.util.List;

@EnableJpaRepositories(basePackages = "com.crm.siigroup.crmApp.repository")
@Repository
public interface CustomerRepository extends JpaRepository<Customers, String> {

    List<Customers> findAll();

    Customers findCustomersById(Long customersId);

    Customers findCustomersByPersonalId(String personalId);

}
