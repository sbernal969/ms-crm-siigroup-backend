package com.crm.siigroup.crmApp.models.entity;

import lombok.Data;

import javax.persistence.*;

@Data
@Table(name = "country")
@Entity
public class CodeArea {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id", nullable = false)
    private Long id;

    @Column
    private String phone_code;

}
