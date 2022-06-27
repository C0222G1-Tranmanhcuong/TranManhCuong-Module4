package com.codegym.furama.model.customer;

import javax.persistence.*;
import java.util.Set;

@Entity(name = "customer_type")
public class CustomerType {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_customer_type")
    private Integer idType;
    @Column(name = "name_customer_type")
    private String nameCustomerType;
    @OneToMany(mappedBy = "customerType")
    private Set<Customer>customers;

    public CustomerType() {
    }

    public CustomerType(Integer idType, String nameCustomerType, Set<Customer> customers) {
        this.idType = idType;
        this.nameCustomerType = nameCustomerType;
        this.customers = customers;
    }

    public Integer getIdType() {
        return idType;
    }

    public void setIdType(Integer idType) {
        this.idType = idType;
    }

    public String getNameCustomerType() {
        return nameCustomerType;
    }

    public void setNameCustomerType(String nameCustomerType) {
        this.nameCustomerType = nameCustomerType;
    }

    public Set<Customer> getCustomers() {
        return customers;
    }

    public void setCustomers(Set<Customer> customers) {
        this.customers = customers;
    }
}
