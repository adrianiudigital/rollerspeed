package com.rollerspeed.controllers;

import java.util.List;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.rollerspeed.dtos.PaymentDTO;
import com.rollerspeed.services.PaymentService;

import lombok.RequiredArgsConstructor;

@RestController
@RequestMapping("${api.base-path}/payments")
@RequiredArgsConstructor
public class PaymentController {

    private final PaymentService paymentService;

    @GetMapping
    public List<PaymentDTO> getAll() {
        return paymentService.getAllPayments();
    }

    @GetMapping("/{id}")
    public ResponseEntity<PaymentDTO> getById(@PathVariable Long id) {
        return paymentService.getById(id)
                .map(ResponseEntity::ok)
                .orElse(ResponseEntity.notFound().build());
    }

    @GetMapping("/pending")
    public List<PaymentDTO> getPending() {
        return paymentService.getPendingPayments();
    }

    @GetMapping("/student/{studentId}")
    public List<PaymentDTO> getByStudent(@PathVariable Long studentId) {
        return paymentService.getPaymentsByStudent(studentId);
    }

    @PostMapping
    public ResponseEntity<PaymentDTO> save(@RequestBody PaymentDTO dto) {
        return ResponseEntity.ok(paymentService.save(dto));
    }

    @PutMapping("/{id}/confirm")
    public ResponseEntity<PaymentDTO> confirm(@PathVariable Long id) {
        return ResponseEntity.ok(paymentService.confirmPayment(id));
    }
}
