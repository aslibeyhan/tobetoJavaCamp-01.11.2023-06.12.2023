package com.tobeto.spring.b.services.concretes;


import com.tobeto.spring.b.entities.Rental;
import com.tobeto.spring.b.repositories.RentalRepository;
import com.tobeto.spring.b.services.abstracts.RentalService;
import com.tobeto.spring.b.services.dtos.requests.rental.AddRentalRequest;
import com.tobeto.spring.b.services.dtos.requests.rental.UpdateRentalRequest;
import com.tobeto.spring.b.services.dtos.responses.rental.GetRentalListResponse;
import com.tobeto.spring.b.services.dtos.responses.rental.GetRentalResponse;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
@Service
@AllArgsConstructor
public class RentalManager implements RentalService {
    private final RentalRepository rentalRepository;
   /* @Override
    public List<GetRentalListResponse> getAll() {
        List<Rental> rentalList=rentalRepository.findAll();
        List<GetRentalListResponse> rentalListResponses=new ArrayList<>();
        for (Rental rental : rentalList) {
            GetRentalListResponse rentalResponse=new GetRentalListResponse();
            rentalResponse.setId(rental.getId());
            rentalResponse.setRental_message(rental.getRental_message());
            rentalListResponses.add(rentalResponse);
        }
        return  rentalListResponses;
    }*/

    @Override
    public List<GetRentalListResponse> getAll() {
        return rentalRepository.getAll();
    }

    @Override
    public List<GetRentalListResponse> getAllUser() {
        return rentalRepository.getAllUser();
    }

    @Override
    public GetRentalResponse getById(int id) {
        Rental rental=rentalRepository.findById(id).orElseThrow();
        GetRentalResponse rentalResponse=new GetRentalResponse();
        rentalResponse.setId(rental.getId());
        rentalResponse.setRental_message(rental.getRental_message());
        return rentalResponse;
    }

    @Override
    public void add(AddRentalRequest addRentalRequest) {
        Rental rental=new Rental();
        rental.setRental_message(addRentalRequest.getRental_message());
        rentalRepository.save(rental);
    }

    @Override
    public void update(UpdateRentalRequest updateRentalRequest) {
      Rental rentalToUpdate=rentalRepository.findById(updateRentalRequest.getId()).orElseThrow();
      rentalToUpdate.setId(updateRentalRequest.getId());
      rentalToUpdate.setRental_message(updateRentalRequest.getRental_message());
      rentalRepository.save(rentalToUpdate);
    }

    @Override
    public void delete(int id) {
        Rental rentalToDelete=rentalRepository.findById(id).orElseThrow();
        rentalRepository.delete(rentalToDelete);
    }
}
