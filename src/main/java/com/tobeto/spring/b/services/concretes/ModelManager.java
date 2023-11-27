package com.tobeto.spring.b.services.concretes;

import com.tobeto.spring.b.entities.Model;
import com.tobeto.spring.b.repositories.ModelRepository;
import com.tobeto.spring.b.services.abstracts.ModelService;
import com.tobeto.spring.b.services.dtos.requests.model.AddModelRequest;
import com.tobeto.spring.b.services.dtos.requests.model.UpdateModelRequest;
import com.tobeto.spring.b.services.dtos.responses.model.GetModelListResponse;
import com.tobeto.spring.b.services.dtos.responses.model.GetModelResponse;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
@Service
@AllArgsConstructor
public class ModelManager implements ModelService {
    private final ModelRepository modelRepository;
    @Override
    public List<GetModelListResponse> getAll() {
        List<Model> modelList=modelRepository.findAll();
        List<GetModelListResponse> modelListResponses=new ArrayList<>();
        for (Model model:modelList) {
            GetModelListResponse modelResponse=new GetModelListResponse();
            modelResponse.setId(model.getId());
            modelResponse.setName(model.getName());
            modelResponse.setYear(model.getYear());
            modelListResponses.add(modelResponse);

        }
        return modelListResponses;
    }

    @Override
    public GetModelResponse getById(int id) {
        Model model=modelRepository.findById(id).orElseThrow();
        GetModelResponse modelResponse=new GetModelResponse();
        modelResponse.setId(model.getId());
        modelResponse.setName(model.getName());
        modelResponse.setYear(model.getYear());
        return modelResponse;

    }

    @Override
    public void add(AddModelRequest addModelRequest) {
        Model model=new Model();
        model.setName(addModelRequest.getName());
        model.setYear(addModelRequest.getYear());
        modelRepository.save(model);
    }

    @Override
    public void update(UpdateModelRequest updateModelRequest) {
        Model modelToUpdate=modelRepository.findById(updateModelRequest.getId()).orElseThrow();
        modelToUpdate.setName(updateModelRequest.getName());
        modelToUpdate.setYear(updateModelRequest.getYear());
        modelRepository.save(modelToUpdate);


    }

    @Override
    public void delete(int id) {
        Model modelToDelete=modelRepository.findById(id).orElseThrow();
        modelRepository.delete(modelToDelete);

    }
}
