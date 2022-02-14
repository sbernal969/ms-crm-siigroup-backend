package com.crm.siigroup.crmApp.repository;

import com.crm.siigroup.crmApp.models.entity.Country;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
import org.springframework.stereotype.Repository;

import java.util.List;

@EnableJpaRepositories(basePackages = "com.crm.siigroup.crmApp.repository")
@Repository
public interface CountryRepository extends JpaRepository<Country, String> {

    List<Country> findAll();

}
