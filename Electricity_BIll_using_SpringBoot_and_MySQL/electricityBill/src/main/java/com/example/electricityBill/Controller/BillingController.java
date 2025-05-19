package com.example.electricityBill.Controller;

import com.example.electricityBill.Entity.Billing;
import com.example.electricityBill.Entity.Consumer;
import com.example.electricityBill.Service.BillingService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api")
public class BillingController {

    private final BillingService billingService;

    public BillingController(BillingService billingService) {
        this.billingService = billingService;
    }

    @PostMapping("/addConsumer")
    public ResponseEntity<Consumer> addConsumer(@RequestBody Consumer c) {
        return ResponseEntity.ok(billingService.addConsumer(c));
    }

    @GetMapping("/allConsumers")
    public ResponseEntity<List<Consumer>> getAllConsumers() {
        return ResponseEntity.ok(billingService.getAllConsumers());
    }

    @PostMapping("/generateBill/{consumerId}")
    public ResponseEntity<Billing> generateBill(@PathVariable Integer consumerId,
            @RequestParam int units) {
        return ResponseEntity.ok(billingService.generateBill(consumerId, units));
    }

    @GetMapping("/allBills")
    public ResponseEntity<List<Billing>> getAllBills() {
        return ResponseEntity.ok(billingService.getAllBills());
    }
    // @GetMapping("/Bill/{consumerId}")
    // public ResponseEntity<List<Billing>> getBillByConsumerId(@PathVariable
    // Integer consumerId) {
    // return ResponseEntity.ok(billingService.getBillByConsumerId(consumerId));
    // }
}
