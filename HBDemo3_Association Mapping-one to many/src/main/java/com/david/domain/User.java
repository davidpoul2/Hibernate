package com.david.domain;

import jakarta.persistence.*;

import java.util.LinkedHashSet;
import java.util.Set;

@Entity
@Table(name = "user")
public class User {
    @Id
    @Column(name = "id", nullable = false)
    private Integer id;

    @Column(name = "name", length = 30)
    private String name;

    @Column(name = "address", length = 40)
    private String address;

    @OneToMany(targetEntity = PhoneNo.class, cascade = CascadeType.ALL, fetch = FetchType.EAGER)
    @JoinColumn(name = "userId", referencedColumnName = "id")
    private Set<PhoneNo> phoneNos = new LinkedHashSet<>();

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getAddress() {
        return address;
    }

    @Override
    public String toString() {
        return "User{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", address='" + address + '\'' +
                ", phoneNos=" + phoneNos +
                '}';
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public Set<PhoneNo> getPhoneNos() {
        return phoneNos;
    }

    public void setPhoneNos(Set<PhoneNo> phoneNos) {
        this.phoneNos = phoneNos;
    }

}