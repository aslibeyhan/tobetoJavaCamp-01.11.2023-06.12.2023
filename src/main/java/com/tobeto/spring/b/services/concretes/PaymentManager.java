package com.tobeto.spring.b.services.concretes;


import com.tobeto.spring.b.entities.Payment;
import com.tobeto.spring.b.repositories.PaymentRepository;
import com.tobeto.spring.b.services.abstracts.PaymentService;
import com.tobeto.spring.b.services.dtos.requests.brand.UpdateBrandRequest;
import com.tobeto.spring.b.services.dtos.requests.payment.AddPaymentRequest;
import com.tobeto.spring.b.services.dtos.requests.payment.UpdatePaymentRequest;
import com.tobeto.spring.b.services.dtos.responses.payment.GetPaymentListResponse;
import com.tobeto.spring.b.services.dtos.responses.payment.GetPaymentResponse;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
@Service
@AllArgsConstructor
public class PaymentManager implements PaymentService {
    private final PaymentRepository paymentRepository;
    @Override
    public List<GetPaymentListResponse> getAll() {
        List<Payment> paymentList=paymentRepository.findAll();
        List<GetPaymentListResponse> paymentListResponses=new ArrayList<>();
        for (Payment payment : paymentList){
            GetPaymentListResponse paymentResponse=new GetPaymentListResponse();
            paymentResponse.setId(payment.getId());
            paymentResponse.setTotal_price(payment.getTotal_price());
            paymentResponse.setPayment_method(payment.getPayment_method());
            paymentListResponses.add(paymentResponse);

        }
        return paymentListResponses;
    }

    @Override
    public List<GetPaymentListResponse> getAllRentalDetail() {
        return paymentRepository.getAllRentalDetail();
    }

    @Override
    public GetPaymentResponse getById(int id) {
        Payment payment = paymentRepository.findById(id).orElseThrow();
        GetPaymentResponse paymentResponse=new GetPaymentResponse();
        paymentResponse.setId(payment.getId());
        paymentResponse.setTotal_price((payment.getTotal_price()));
        paymentResponse.setPayment_method(payment.getPayment_method());
        return paymentResponse;
    }
    @Override
    public void add(AddPaymentRequest addPaymentRequest) {
      Payment payment=new Payment();
      payment.setTotal_price(addPaymentRequest.getTotal_price());
      payment.setPayment_method(addPaymentRequest.getPayment_method());
      paymentRepository.save(payment);
    }

    @Override
    public void update(UpdatePaymentRequest updatePaymentRequest) {
       Payment paymentToUpdate=paymentRepository.findById(updatePaymentRequest.getId()).orElseThrow();
       paymentToUpdate.setId(updatePaymentRequest.getId());
       paymentToUpdate.setPayment_method(updatePaymentRequest.getPayment_method());
       paymentToUpdate.setTotal_price((updatePaymentRequest.getTotal_price()));

       paymentRepository.save(paymentToUpdate);
    }

    @Override
    public void delete(int id) {
        Payment paymentToDelete=paymentRepository.findById(id).orElseThrow();
        paymentRepository.delete(paymentToDelete);

    }
}
