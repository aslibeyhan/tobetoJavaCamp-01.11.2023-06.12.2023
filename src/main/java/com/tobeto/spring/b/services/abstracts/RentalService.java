package com.tobeto.spring.b.services.abstracts;

import com.tobeto.spring.b.services.dtos.requests.rental.AddRentalRequest;
import com.tobeto.spring.b.services.dtos.requests.rental.UpdateRentalRequest;
import com.tobeto.spring.b.services.dtos.responses.rental.GetRentalListResponse;
import com.tobeto.spring.b.services.dtos.responses.rental.GetRentalResponse;

import java.util.List;

public interface RentalService {
    List<GetRentalListResponse> getAll();
    GetRentalResponse getById(int id);
    public void add(AddRentalRequest addRentalRequest);
    public  void update(UpdateRentalRequest updateRentalRequest);
    public void delete(int id);
}
