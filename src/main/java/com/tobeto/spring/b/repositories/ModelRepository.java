package com.tobeto.spring.b.repositories;

import com.tobeto.spring.b.entities.Model;
import com.tobeto.spring.b.services.dtos.responses.model.GetModelListResponse;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface ModelRepository extends JpaRepository<Model,Integer> {

    @Query("SELECT new com.tobeto.spring.b.services.dtos.responses.model" +
            ".GetModelListResponse(m.id,m.name,m.year,new com.tobeto.spring.b.services.dtos.responses.brand.GetBrandListResponse(b.name))" +
            "FROM Model m INNER JOIN m.brand b")
    List<GetModelListResponse> getAll();


}
