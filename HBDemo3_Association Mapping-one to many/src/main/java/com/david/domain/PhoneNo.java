package com.david.domain;

import jakarta.persistence.*;

import java.math.BigDecimal;

@Entity
@Table(name = "phone_no")
public class PhoneNo {
    @Id
    @Column(name = "phone", nullable = false, precision = 10)
    private BigDecimal id;

    @Column(name = "provider", length = 20)
    private String provider;

    public BigDecimal getId() {
        return id;
    }

    public void setId(BigDecimal id) {
        this.id = id;
    }

    public String getProvider() {
        return provider;
    }

    public void setProvider(String provider) {
        this.provider = provider;
    }

    @Override
    public String toString() {
        return "PhoneNo{" +
                "id=" + id +
                ", provider='" + provider + '\'' +
                '}';
    }
}