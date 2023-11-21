package com.tobeto.spring.b.controllers;

import com.tobeto.spring.b.entities.RentalDetail;
import com.tobeto.spring.b.repositories.RentalDetailRepository;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("api/rentalDetails")
public class RentalDetailsController {

    private final RentalDetailRepository rentalDetailRepository;

    public RentalDetailsController(RentalDetailRepository rentalDetailRepository) {
        this.rentalDetailRepository = rentalDetailRepository;
    }

    @GetMapping
    public List<RentalDetail> getAll(){
        return rentalDetailRepository.findAll();
    }

    @GetMapping("{id}")
    public RentalDetail getById(@PathVariable int id){

        return rentalDetailRepository.findById(id).orElseThrow();
    }

    @PostMapping
    public void add(@RequestBody RentalDetail rentalDetail){
        rentalDetailRepository.save(rentalDetail);
    }

    @PutMapping
    public void update(@RequestBody RentalDetail rentalDetail){
        rentalDetailRepository.findById(rentalDetail.getId()).orElseThrow();
        rentalDetailRepository.save(rentalDetail);
    }

    @DeleteMapping("{id}")
    public void delete(@PathVariable int id){
        RentalDetail rentalDetailToDelete=rentalDetailRepository.findById(id).orElseThrow();
        rentalDetailRepository.delete(rentalDetailToDelete);
    }
}
