package com.tobeto.spring.b.services.concretes;
import com.tobeto.spring.b.entities.Rental;
import com.tobeto.spring.b.entities.RentalDetail;
import com.tobeto.spring.b.repositories.RentalDetailRepository;
import com.tobeto.spring.b.services.abstracts.RentalDetailService;
import com.tobeto.spring.b.services.dtos.requests.rentalDetail.AddRentalDetailRequest;
import com.tobeto.spring.b.services.dtos.requests.rentalDetail.UpdateRentalDetailRequest;


import com.tobeto.spring.b.services.dtos.responses.rentalDetail.GetRentalDetailListResponse;
import com.tobeto.spring.b.services.dtos.responses.rentalDetail.GetRentalDetailResponse;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
@Service
@AllArgsConstructor
public class RentalDetailManager implements RentalDetailService {
    private final RentalDetailRepository rentalDetailRepository;
    @Override
    public List<GetRentalDetailListResponse> getAll() {
        List<RentalDetail> rentalDetailList=rentalDetailRepository.findAll();
        List<GetRentalDetailListResponse> rentalDetailListResponses=new ArrayList<>();
        for (RentalDetail rentalDetail:rentalDetailList) {
            GetRentalDetailListResponse rentalDetailListResponse=new GetRentalDetailListResponse();
           rentalDetailListResponse.setId(rentalDetail.getId());
           rentalDetailListResponse.setStart_date(rentalDetail.getStart_date());
           rentalDetailListResponse.setEnd_date(rentalDetail.getEnd_date());
           rentalDetailListResponse.setTotal_cost(rentalDetail.getTotal_cost());
            rentalDetailListResponses.add(rentalDetailListResponse);

        }
        return rentalDetailListResponses;
    }

    @Override
    public List<GetRentalDetailListResponse> getAllRental() {
        return rentalDetailRepository.getAllRental();
    }


    @Override
    public GetRentalDetailResponse getById(int id) {
        RentalDetail rentalDetail = rentalDetailRepository.findById(id).orElseThrow();
        GetRentalDetailResponse rentalDetailResponse=new GetRentalDetailResponse();
        rentalDetailResponse.setId(rentalDetail.getId());
        rentalDetailResponse.setStart_date(rentalDetail.getStart_date());
        rentalDetailResponse.setEnd_date(rentalDetail.getEnd_date());
        rentalDetailResponse.setTotal_cost(rentalDetail.getTotal_cost());
        return  rentalDetailResponse;
    }

    @Override
    public void add(AddRentalDetailRequest addRentalDetailRequest) {
        RentalDetail rentalDetail=new RentalDetail();
        rentalDetail.setStart_date(addRentalDetailRequest.getStart_date());
        rentalDetail.setEnd_date(addRentalDetailRequest.getEnd_date());
        rentalDetail.setTotal_cost(addRentalDetailRequest.getTotal_cost());
        rentalDetailRepository.save(rentalDetail);
    }

    @Override
    public void update(UpdateRentalDetailRequest updateRentalDetailRequest) {
        RentalDetail rentalDetailToUpdate=rentalDetailRepository.findById(updateRentalDetailRequest.getId()).orElseThrow();
        rentalDetailToUpdate.setId(updateRentalDetailRequest.getId());
        rentalDetailToUpdate.setStart_date(updateRentalDetailRequest.getStart_date());
        rentalDetailToUpdate.setEnd_date(updateRentalDetailRequest.getEnd_date());
        rentalDetailToUpdate.setTotal_cost(updateRentalDetailRequest.getTotal_cost());
        rentalDetailRepository.save(rentalDetailToUpdate);
    }

    @Override
    public void delete(int id) {
        RentalDetail rentalToDelete=rentalDetailRepository.findById(id).orElseThrow();
        rentalDetailRepository.delete(rentalToDelete);

    }
}
