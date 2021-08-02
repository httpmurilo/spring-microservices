package com.murilo.hrpayroll.services;

import com.murilo.hrpayroll.entities.Payment;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;

@Service
public class PaymentService {

    public Payment getPayment(long workerId, int days){
        return new Payment("bob",200.0,days);
    }
}
