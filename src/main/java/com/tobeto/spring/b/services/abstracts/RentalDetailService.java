package com.tobeto.spring.b.services.abstracts;

import com.tobeto.spring.b.services.dtos.requests.rentalDetail.AddRentalDetailRequest;
import com.tobeto.spring.b.services.dtos.requests.rentalDetail.UpdateRentalDetailRequest;
import com.tobeto.spring.b.services.dtos.responses.rental.GetRentalListResponse;
import com.tobeto.spring.b.services.dtos.responses.rental.GetRentalResponse;
import com.tobeto.spring.b.services.dtos.responses.rentalDetail.GetRentalDetailListResponse;
import com.tobeto.spring.b.services.dtos.responses.rentalDetail.GetRentalDetailResponse;

import java.util.List;

public interface RentalDetailService {
    List<GetRentalDetailListResponse> getAll();
    GetRentalDetailResponse  getById(int id);
    public void add(AddRentalDetailRequest addRentalDetailRequest);
    public void update(UpdateRentalDetailRequest updateRentalDetailRequest);
    public void delete(int id);

}
