package com.rollerspeed.services;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

import org.springframework.stereotype.Service;

import com.rollerspeed.dtos.PaymentDTO;
import com.rollerspeed.mappers.PaymentMapper;
import com.rollerspeed.models.Payment;
import com.rollerspeed.models.User;
import com.rollerspeed.models.enums.PaymentStatus;
import com.rollerspeed.repositories.PaymentRepository;
import com.rollerspeed.repositories.UserRepository;

import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class PaymentService {

    private final PaymentRepository paymentRepository;
    private final UserRepository userRepository;
    private final PaymentMapper paymentMapper;

    public List<PaymentDTO> getAllPayments() {
        return paymentRepository.findAll().stream()
                .map(paymentMapper::toDTO)
                .collect(Collectors.toList());
    }

    public List<PaymentDTO> getPaymentsByStudent(Long studentId) {
        return paymentRepository.findByStudentId(studentId).stream()
                .map(paymentMapper::toDTO)
                .collect(Collectors.toList());
    }

    public List<PaymentDTO> getPendingPayments() {
        return paymentRepository.findByPaymentStatus(PaymentStatus.PENDING).stream()
                .map(paymentMapper::toDTO)
                .collect(Collectors.toList());
    }

    public PaymentDTO save(PaymentDTO dto) {
        User student = userRepository.findById(dto.getStudentId())
                .orElseThrow(
                        () -> new IllegalArgumentException("Estudiante no encontrado con ID: " + dto.getStudentId()));
        Payment payment = paymentMapper.toEntity(dto, student);
        return paymentMapper.toDTO(paymentRepository.save(payment));
    }

    public PaymentDTO confirmPayment(Long id) {
        Payment payment = paymentRepository.findById(id)
                .orElseThrow(() -> new IllegalArgumentException("Pago no encontrado con ID: " + id));
        payment.setPaymentStatus(PaymentStatus.CONFIRMED);
        return paymentMapper.toDTO(paymentRepository.save(payment));
    }

    public Optional<PaymentDTO> getById(Long id) {
        return paymentRepository.findById(id).map(paymentMapper::toDTO);
    }
}
