package com.rollerspeed.repositories;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.rollerspeed.models.Payment;
import com.rollerspeed.models.enums.PaymentStatus;

public interface PaymentRepository extends JpaRepository<Payment, Long> {
    List<Payment> findByStudentId(Long studentId);

    List<Payment> findByPaymentStatus(PaymentStatus status);
}
