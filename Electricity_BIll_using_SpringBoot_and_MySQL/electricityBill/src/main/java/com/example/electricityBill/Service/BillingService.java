package com.example.electricityBill.Service;

import com.example.electricityBill.Entity.Billing;
import com.example.electricityBill.Entity.Consumer;
import com.example.electricityBill.Repository.BillingRepo;
import com.example.electricityBill.Repository.ConsumerRepo;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class BillingService {

    private final ConsumerRepo consumerRepo;
    private final BillingRepo billingRepo;

    public BillingService(ConsumerRepo consumerRepo, BillingRepo billingRepo) {
        this.consumerRepo = consumerRepo;
        this.billingRepo = billingRepo;
    }

    public Consumer addConsumer(Consumer c) {
        return consumerRepo.save(c);
    }

    public List<Consumer> getAllConsumers() {
        return consumerRepo.findAll();
    }
//    public List<Billing> getBillByConsumerId(int consumerId){
//        return billingRepo.findByConsumer_Id(consumerId);
//    }

    public Billing generateBill(Integer consumer_id, int units) {
        Consumer consumer = consumerRepo.findById(consumer_id)
                .orElseThrow(() -> new RuntimeException("Consumer not found"));

        double amount = calculate(units);
        Billing billing = new Billing(consumer, units, amount);
        return billingRepo.save(billing);
    }

    public List<Billing> getAllBills() {
        return billingRepo.findAll();
    }

    private double calculate(int u) {
        if (u <= 50) return u * 3.5;
        if (u <= 150) return 50 * 3.5 + (u - 50) * 4.0;
        if (u <= 250) return 50 * 3.5 + 100 * 4.0 + (u - 150) * 5.2;
        return 50 * 3.5 + 100 * 4.0 + 100 * 5.2 + (u - 250) * 6.5;
    }
}
