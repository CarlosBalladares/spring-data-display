package com.example.FirstSpringApp.model;

import javax.persistence.*;

/**
 * Created by carlosballadares on 2018-07-27.
 */
@Entity
public class Publisher {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String name;
    private String Address;



    public Publisher() {
    }

    public Publisher(String name, String address) {
        this.name = name;
        Address = address;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getAddress() {
        return Address;
    }

    public void setAddress(String address) {
        Address = address;
    }

}
