package com.bank.entity;

import javax.persistence.*;

/**
 * Created by bhuvneshwars on 16/5/18.
 */
@Entity
@Table(name = "bank")
public class Bank {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private long id;

    @Column(nullable = false)
    String name;

    public long getId() {
        return id;
    }

    public Bank(){}

    public Bank(String name) {
        this.name = name;
    }
}
