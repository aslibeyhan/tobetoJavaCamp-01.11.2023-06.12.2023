package com.tobeto.spring.b.services.concretes;

import com.tobeto.spring.b.entities.Brand;
import com.tobeto.spring.b.entities.Car;
import com.tobeto.spring.b.entities.Model;
import com.tobeto.spring.b.repositories.CarRepository;
import com.tobeto.spring.b.services.abstracts.CarService;
import com.tobeto.spring.b.services.dtos.requests.car.AddCarRequest;
import com.tobeto.spring.b.services.dtos.requests.car.UpdateCarRequest;
import com.tobeto.spring.b.services.dtos.responses.brand.GetBrandListResponse;
import com.tobeto.spring.b.services.dtos.responses.brand.GetBrandResponse;
import com.tobeto.spring.b.services.dtos.responses.car.GetCarListResponse;
import com.tobeto.spring.b.services.dtos.responses.car.GetCarResponse;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
@AllArgsConstructor
@Service
public class CarManager implements CarService {
    private final CarRepository carRepository;

    /*@Override
    public List<GetCarListResponse> getAll() {
        List<Car> cars = carRepository.findAll();
        List<GetCarListResponse> carResponses = new ArrayList<GetCarListResponse>();
        for (Car car:cars
        ) {
            GetCarListResponse carResponse = new GetCarListResponse();


            carResponse.setId(car.getId());
            carResponse.setDaily_price(car.getDaily_price());
            carResponse.setPlate(car.getPlate());
            carResponses.add(carResponse);


        }
        return carResponses;
    }*/

    @Override
    public List<GetCarListResponse> getAll() {
        return carRepository.getAll();
    }

    @Override
    public GetCarResponse getById(int id) {
        Car  car = carRepository.findById(id).orElseThrow();
        GetCarResponse carResponse = new GetCarResponse();
        carResponse.setId(car.getId());
        carResponse.setDaily_price(car.getDaily_price());
        carResponse.setPlate(car.getPlate());

        return carResponse;
    }

    @Override
    public void add(AddCarRequest addCarRequest) {
        Car car = new Car();
        car.setPlate(addCarRequest.getPlate());
        car.setDaily_price(addCarRequest.getDaily_price());
        carRepository.save(car);
    }

    @Override
    public void update(UpdateCarRequest updateCarRequest) {
        Car carToUpdate =carRepository.findById(updateCarRequest.getId()).orElseThrow();
      carToUpdate.setId(updateCarRequest.getId());
        carRepository.save(carToUpdate);

    }

    @Override
    public void delete(int id) {
     Car carToDelete=carRepository.findById(id).orElseThrow();
     carRepository.delete(carToDelete);

    }
}
