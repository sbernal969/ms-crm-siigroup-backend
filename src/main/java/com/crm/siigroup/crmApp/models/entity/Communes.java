package com.crm.siigroup.crmApp.models.entity;

import lombok.Data;

import javax.persistence.*;

@Data
@Table(name = "communes")
@Entity
public class Communes {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long communesId;

    @Column
    private String glosa;

}
