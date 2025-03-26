package com.rollerspeed.mappers;

import org.springframework.stereotype.Component;

import com.rollerspeed.dtos.PaymentDTO;
import com.rollerspeed.models.Payment;
import com.rollerspeed.models.User;

@Component
public class PaymentMapper {

    public PaymentDTO toDTO(Payment payment) {
        return PaymentDTO.builder()
                .id(payment.getId())
                .studentId(payment.getStudent().getId())
                .amount(payment.getAmount())
                .paymentDate(payment.getPaymentDate())
                .paymentMethod(payment.getPaymentMethod())
                .paymentStatus(payment.getPaymentStatus())
                .build();
    }

    public Payment toEntity(PaymentDTO dto, User student) {
        return Payment.builder()
                .student(student)
                .amount(dto.getAmount())
                .paymentDate(dto.getPaymentDate())
                .paymentMethod(dto.getPaymentMethod())
                .paymentStatus(dto.getPaymentStatus())
                .build();
    }
}
