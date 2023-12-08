
package com.projetofaculdade.fasterfood.controllers.services;

import com.projetofaculdade.fasterfood.controllers.services.exceptions.DatabaseException;
import com.projetofaculdade.fasterfood.controllers.services.exceptions.ResourceNotFoundException;
import com.projetofaculdade.fasterfood.entities.Payment;
import com.projetofaculdade.fasterfood.repositories.PaymentRepository;
import jakarta.persistence.EntityNotFoundException;
import java.util.Optional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.stereotype.Service;

@Service
public class PaymentServices {

    @Autowired
    private PaymentRepository paymentRepository;

    public Payment insert(Payment payment) {
        return paymentRepository.save(payment);
    }

    public Payment update(Payment payment, Long id) {
        try {
            Payment entity = paymentRepository.getReferenceById(id);
            updateData(entity, payment);
            return paymentRepository.save(entity);
        } catch (EntityNotFoundException ex) {
            throw new ResourceNotFoundException(id);
        }
    }

    public void updateData(Payment entity, Payment payment) {
        entity.setOrder(payment.getOrder());
        entity.setRegistrationTime(payment.getRegistrationTime());
    }

    public void delete(Long id) {
        try {
            paymentRepository.deleteById(id);
        } catch (EmptyResultDataAccessException ex) {
            throw new ResourceNotFoundException(id);
        } catch (DataIntegrityViolationException ex) {
            throw new DatabaseException(ex.getMessage());
        }
    }

    public Payment findById(Long id) {
        Optional<Payment> payment = paymentRepository.findById(id);
        return payment.get();
    }
}
