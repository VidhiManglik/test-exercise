package com.booking.recruitment.hotel.repository;

import com.booking.recruitment.hotel.model.City;
import com.booking.recruitment.hotel.model.Hotel;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;
import java.util.Optional;

public interface HotelRepository extends JpaRepository<Hotel, Long> {
    @Query("SELECT h FROM Hotel h WHERE h.city = ?1 AND h.deleted = false")
    List<Hotel> findByCityAndDeletedFalse(City city);

    Optional<Hotel> findByIdAndDeletedFalse(Long id);

}
