package com.example.electricityBill.Repository;

import com.example.electricityBill.Entity.Billing;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface BillingRepo extends JpaRepository<Billing,Integer> {
}
