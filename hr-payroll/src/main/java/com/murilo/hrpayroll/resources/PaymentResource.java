package com.murilo.hrpayroll.resources;

import com.murilo.hrpayroll.entities.Payment;
import com.murilo.hrpayroll.services.PaymentService;
import com.netflix.ribbon.proxy.annotation.Hystrix;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.util.MultiValueMap;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping(value="payments")
public class PaymentResource {

    @Autowired
    private PaymentService service;

    //@GetMapping(value = "/{workerId}/days/{days}")
    //@ResponseStatus(HttpStatus.OK)
    //public Payment getPayment(@PathVariable Long workerId, @PathVariable Integer days){
    //    return  this.service.getPayment(workerId,days);

    //}
    //@Hystrix(fallbackHandler = "getPaymentAlternative")
    //@Hystrix()
    //@Hystrix()
    @GetMapping(value = "/{workerId}/days/{days}")
    @ResponseStatus(HttpStatus.OK)
    public ResponseEntity<Payment> getPaymentResult(@PathVariable Long workerId, @PathVariable Integer days) {
        Payment payment = this.service.getPayment(workerId, days);
        return ResponseEntity.ok(payment);
    }
    public ResponseEntity<Payment> getPaymentAlternative(Long workerId, Integer days) {
        Payment payment = new Payment("Murilo",400.0, days);
        return ResponseEntity.ok(payment);
    }

}
