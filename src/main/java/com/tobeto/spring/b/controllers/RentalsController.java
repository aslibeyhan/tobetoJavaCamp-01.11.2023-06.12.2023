package com.tobeto.spring.b.controllers;

import com.tobeto.spring.b.entities.Rental;
import com.tobeto.spring.b.repositories.RentalRepository;
import com.tobeto.spring.b.services.abstracts.RentalService;
import com.tobeto.spring.b.services.dtos.requests.rental.AddRentalRequest;
import com.tobeto.spring.b.services.dtos.requests.rental.UpdateRentalRequest;
import com.tobeto.spring.b.services.dtos.responses.rental.GetRentalListResponse;
import com.tobeto.spring.b.services.dtos.responses.rental.GetRentalResponse;
import jakarta.validation.Valid;
import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("api/rentals")
@AllArgsConstructor
public class RentalsController {

    private final RentalService rentalService;



    @GetMapping
    public List<GetRentalListResponse> gelAll(){
        return rentalService.getAll();
    }
    @GetMapping("getAllUser")
    public List<GetRentalListResponse> getAllUser(){
        return  rentalService.getAllUser();
    }

    @GetMapping("{id}")
    public GetRentalResponse getById(@PathVariable int id){
       return rentalService.getById(id);
    }

    @PostMapping
    public void add(@RequestBody  @Valid  AddRentalRequest addRentalRequest){
        rentalService.add(addRentalRequest);
    }

    @PutMapping
    public void update(@RequestBody UpdateRentalRequest updateRentalRequest){
     rentalService.update(updateRentalRequest);
    }

    @DeleteMapping("{id}")
    public void delete(@PathVariable int id){
       rentalService.delete(id);
    }
}
