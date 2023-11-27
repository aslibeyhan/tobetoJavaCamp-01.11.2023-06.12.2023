package com.tobeto.spring.b.controllers;

import com.tobeto.spring.b.entities.Payment;
import com.tobeto.spring.b.repositories.PaymentRepository;
import com.tobeto.spring.b.services.abstracts.PaymentService;
import com.tobeto.spring.b.services.dtos.requests.payment.AddPaymentRequest;
import com.tobeto.spring.b.services.dtos.requests.payment.UpdatePaymentRequest;
import com.tobeto.spring.b.services.dtos.responses.car.GetCarListResponse;
import com.tobeto.spring.b.services.dtos.responses.payment.GetPaymentListResponse;
import com.tobeto.spring.b.services.dtos.responses.payment.GetPaymentResponse;
import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("api/payments")
@AllArgsConstructor
public class PaymentsController {

    private final PaymentService paymentService;


    @GetMapping
    public List<GetPaymentListResponse> getAll(){
        return paymentService.getAll();
    }

    @GetMapping("{id}")
    public GetPaymentResponse  getById(@PathVariable int id){
        return paymentService.getById(id);
    }

    @PostMapping
    public void add(@RequestBody AddPaymentRequest addPaymentRequest){
        paymentService.add(addPaymentRequest);
    }
    @PutMapping()
    public void update(@RequestBody UpdatePaymentRequest updatePaymentRequest){
      paymentService.update(updatePaymentRequest);
    }

    @DeleteMapping("{id}")
    public void delete(@PathVariable int id){
       paymentService.delete(id);
    }


}
