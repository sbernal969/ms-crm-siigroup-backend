package com.crm.siigroup.crmApp.models.entity;


import lombok.Data;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;

@Data
@Entity
public class Users {

    @Id
    @Column(name = "id", nullable = false)
    private Long id;

    @Column
    private String username;

    @Column
    private String name;

    @Column
    private String lastName;

    @Column
    private Boolean status;

    @Column
    private String password;

    @Column
    private int typeRol;
}
