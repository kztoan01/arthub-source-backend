package com.example.ArtHub.Entity;

import jakarta.persistence.*;

import java.util.Date;
import java.util.List;

@Entity
public class Orders {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    int id;
    @ManyToOne
    @JoinColumn(name = "accountId")
    private Account account;
    private Date date;
    @OneToMany
    private List<OrdersDetails> ordersDetails;

    public Orders() {
    }

    public Orders(int id, Account account, Date date, List<OrdersDetails> ordersDetails) {
        this.id = id;
        this.account = account;
        this.date = date;
        this.ordersDetails = ordersDetails;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public Account getAccount() {
        return account;
    }

    public void setAccount(Account account) {
        this.account = account;
    }

    public Date getDate() {
        return date;
    }

    public void setDate(Date date) {
        this.date = date;
    }

    public List<OrdersDetails> getOrdersDetails() {
        return ordersDetails;
    }

    public void setOrdersDetails(List<OrdersDetails> ordersDetails) {
        this.ordersDetails = ordersDetails;
    }
}
