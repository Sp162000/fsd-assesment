package com.fsd.assesment.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.fsd.assesment.model.Hotel;

@Repository
public interface HotelRepository extends JpaRepository<Hotel,Long> {

}
