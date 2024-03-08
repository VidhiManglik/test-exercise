package com.booking.recruitment.hotel.service;

import com.booking.recruitment.hotel.model.Hotel;

import java.util.List;

public interface HotelService {
  List<Hotel> getAllHotels();

  List<Hotel> getHotelsByCity(Long cityId);

  Hotel getHotelById(Long id);

  Hotel createNewHotel(Hotel hotel);

  void deleteHotelById(Long id);

  List<Hotel> searchHotelsByCityAndSortByDistance(Long cityId, String sortBy);
}
