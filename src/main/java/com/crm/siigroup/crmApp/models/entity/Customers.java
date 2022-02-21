package com.crm.siigroup.crmApp.models.entity;

import lombok.Data;

import javax.persistence.*;
import java.io.Serializable;
import java.util.Date;

@Data
@Table(name = "customer")
@Entity
public class Customers implements Serializable {

    private static final long serialVersionUID = 1L;

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "customer_id", nullable = false)
    private Long id;

    @Column
    private String personalId;

    @Column
    private String name;

    @Column
    private String familyFirstName;

    @Column
    private String familySecondName;

    @Column
    private String birth;

    @ManyToOne
    @JoinColumn(name = "nationality_id")
    private Nationality nationality;

    @ManyToOne
    @JoinColumn(name = "gender_id")
    private Gender gender;

    @Column
    private String email;

    @Column
    private Long mobileNumber;

    @ManyToOne
    @JoinColumn(name = "mobileCode_id")
    private Country mobileNumberCode;

    @Column
    private Long fixNumber;

    @ManyToOne
    @JoinColumn(name = "fixCode_id")
    private Country fixNumberCode;

    @ManyToOne
    @JoinColumn(name = "addressCountry_id")
    private Country addressCountry;

    @Column
    private String addressStreet;

    @Column
    private Long addressNumber;

    /*@ManyToOne
    @JoinColumn(name = "addressComune_id")
    private Communes addressComune;*/

    @Column
    private String addressComune;

    @Column
    private Long addressPostalCode;

    @Column
    private String addressCity;

    @Column
    private String addressAditional;

    @Column
    private Long income;

    @ManyToOne
    @JoinColumn(name = "currency_id")
    private Currency currency;

    @Column
    private int tipeOfClient;

    @ManyToOne
    @JoinColumn(name = "country_id")
    private Country country;

}
