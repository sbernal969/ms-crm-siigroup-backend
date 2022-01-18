package com.crm.siigroup.crmApp.repository;

import com.crm.siigroup.crmApp.models.entity.Users;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
import org.springframework.stereotype.Repository;


@EnableJpaRepositories(basePackages = "com.crm.siigroup.crmApp.repository")
@Repository
public interface UserRepository extends JpaRepository<Users, String> {

    Users findByUsername(String username);
}
