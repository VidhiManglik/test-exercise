package com.booking.recruitment.hotel.service;

import com.booking.recruitment.hotel.dto.HotelDTO;
import com.booking.recruitment.hotel.model.Hotel;

import java.util.List;

public interface HotelService {
  List<Hotel> getAllHotels();

  List<Hotel> getHotelsByCity(Long cityId);

  HotelDTO getHotelById(Long id);

  Hotel createNewHotel(Hotel hotel);

  void deleteHotelById(Long id);

  List<HotelDTO> searchHotelsByCityAndSortByDistance(Long cityId, String sortBy);
}
