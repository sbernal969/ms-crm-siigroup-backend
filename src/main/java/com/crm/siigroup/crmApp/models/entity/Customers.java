package com.crm.siigroup.crmApp.models.entity;

import lombok.Data;

import javax.persistence.*;

@Data
@Table(name = "customer")
@Entity
public class Customers {
    
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id", nullable = false)
    private Long id;

    @Column
    private String rut;

    @Column
    private String firstName;

    @Column
    private String familyName;

    @Column
    private String birth;

    @Column
    private String country;

    @Column
    private String nacionality;

    @Column
    private String gender;

    @Column
    private String email;

    @Column
    private String mobileNumber;

    @Column
    private String fixNumber;

    @Column
    private String postalAddress;

    @Column
    private int income;

    @Column
    private int tipeOfClient;

}
