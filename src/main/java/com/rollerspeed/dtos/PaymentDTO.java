package com.rollerspeed.dtos;

import java.time.LocalDateTime;

import com.rollerspeed.models.enums.PaymentMethod;
import com.rollerspeed.models.enums.PaymentStatus;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class PaymentDTO {
    private Long id;
    private Long studentId;
    private Double amount;
    private LocalDateTime paymentDate;
    private PaymentMethod paymentMethod;
    private PaymentStatus paymentStatus;
}
