package com.tobeto.spring.b.repositories;

import com.tobeto.spring.b.entities.Brand;
import com.tobeto.spring.b.services.dtos.responses.brand.GetBrandListResponse;
import org.springframework.data.domain.Example;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface BrandRepository extends JpaRepository<Brand,Integer> {
   //DERİVED QUERY METHODS
    List<Brand> findByName(String name);
    List<Brand> findByNameLikeOrIdEquals(String name,int id);

    boolean existsByName(String name);

   //JPA +SQL => JPQL
   //SELECT *FROM brands sqldeki sorgu ;
   //@Query("SELECT b FROM Brand b WHERE b.name LIKE '%an%'")
   //@Query("SELECT b FROM Brand b WHERE b.name=:name")
   @Query("SELECT b FROM Brand b WHERE b.name LIKE %:name%")
   List<Brand> search(String name);

   //SQL yazmak istersen nativeQuery true kull
   @Query(value = "SELECT *FROM brands WHERE name LIKE %:name%", nativeQuery = true)
   List<Brand> search2(String name);

   // b-->Brand
   // expected ---> GerBrandListResponse

   @Query("SELECT new com.tobeto.spring.b.services.dtos.responses.brand.GetBrandListResponse(b.name) "+
           "FROM Brand b WHERE b.name LIKE %:name%")
   List<GetBrandListResponse> search3(String name);





}
