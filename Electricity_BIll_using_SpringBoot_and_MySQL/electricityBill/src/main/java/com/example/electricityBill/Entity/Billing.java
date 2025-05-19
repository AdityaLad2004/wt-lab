package com.example.electricityBill.Entity;

import jakarta.persistence.*;

import java.time.LocalDateTime;

@Entity
public class Billing {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int billing_id;

    @ManyToOne
    @JoinColumn(name = "consumer_id")
    private Consumer consumer;
    private int units;
    private double amount;

    public Billing() {
    }

    public Billing(Consumer consumer, int units, double amount) {
        this.consumer = consumer;
        this.units = units;
        this.amount = amount;
    }

    private LocalDateTime billDate = LocalDateTime.now();

    public int getBilling_id() {
        return billing_id;
    }

    public void setBilling_id(int billing_id) {
        this.billing_id = billing_id;
    }

    public Consumer getConsumer() {
        return consumer;
    }

    public void setConsumer(Consumer consumer) {
        this.consumer = consumer;
    }

    public int getUnits() {
        return units;
    }

    public void setUnits(int units) {
        this.units = units;
    }

    public double getAmount() {
        return amount;
    }

    public void setAmount(double amount) {
        this.amount = amount;
    }

    public LocalDateTime getBillDate() {
        return billDate;
    }

    public void setBillDate(LocalDateTime billDate) {
        this.billDate = billDate;
    }
}
