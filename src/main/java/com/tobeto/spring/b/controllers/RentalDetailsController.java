package com.tobeto.spring.b.controllers;

import com.tobeto.spring.b.entities.RentalDetail;
import com.tobeto.spring.b.repositories.RentalDetailRepository;
import com.tobeto.spring.b.services.abstracts.RentalDetailService;
import com.tobeto.spring.b.services.dtos.requests.rentalDetail.AddRentalDetailRequest;
import com.tobeto.spring.b.services.dtos.requests.rentalDetail.UpdateRentalDetailRequest;
import com.tobeto.spring.b.services.dtos.responses.rentalDetail.GetRentalDetailListResponse;
import com.tobeto.spring.b.services.dtos.responses.rentalDetail.GetRentalDetailResponse;
import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("api/rentalDetails")
@AllArgsConstructor
public class RentalDetailsController {

    private final RentalDetailService rentalDetailService;



    @GetMapping
    public List<GetRentalDetailListResponse> getAll(){
        return rentalDetailService.getAll();
    }

    @GetMapping("getAllRental")
    public  List<GetRentalDetailListResponse> getAllRental(){
        return  rentalDetailService.getAllRental();
    }

    @GetMapping("{id}")
    public GetRentalDetailResponse getById(@PathVariable int id){

       return  rentalDetailService.getById(id);
    }

    @PostMapping
    public void add(@RequestBody AddRentalDetailRequest addRentalDetailRequest){
       rentalDetailService.add(addRentalDetailRequest);
    }

    @PutMapping
    public void update(@RequestBody UpdateRentalDetailRequest updateRentalDetailRequest){
       rentalDetailService.update(updateRentalDetailRequest);
    }

    @DeleteMapping("{id}")
    public void delete(@PathVariable int id){
        rentalDetailService.delete(id);
    }
}
