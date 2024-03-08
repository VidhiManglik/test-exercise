package com.booking.recruitment.hotel.service.impl;

import com.booking.recruitment.hotel.exception.BadRequestException;
import com.booking.recruitment.hotel.exception.ElementNotFoundException;
import com.booking.recruitment.hotel.model.City;
import com.booking.recruitment.hotel.model.Hotel;
import com.booking.recruitment.hotel.repository.CityRepository;
import com.booking.recruitment.hotel.repository.HotelRepository;
import com.booking.recruitment.hotel.service.HotelService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;

@Service
class DefaultHotelService implements HotelService {
  private final HotelRepository hotelRepository;
  private final CityRepository cityRepository;

  @Autowired
  DefaultHotelService(
    HotelRepository hotelRepository,
    CityRepository cityRepository
  ) {
    this.hotelRepository = hotelRepository;
    this.cityRepository = cityRepository;
  }

  @Override
  public List<Hotel> getAllHotels() {
    return hotelRepository.findAll();
  }

  @Override
  public List<Hotel> getHotelsByCity(Long cityId) {
    return hotelRepository.findAll().stream()
        .filter((hotel) -> cityId.equals(hotel.getCity().getId()))
        .collect(Collectors.toList());
  }

  @Override
  public Hotel createNewHotel(Hotel hotel) {
    if (hotel.getId() != null) {
      throw new BadRequestException("The ID must not be provided when creating a new Hotel");
    }

    return hotelRepository.save(hotel);
  }

  @Override
  public Hotel getHotelById(Long id) {
    return hotelRepository
            .findByIdAndDeletedFalse(id)
            .orElseThrow(() -> new ElementNotFoundException("Could not find hotel with ID provided"));
  }

  @Override
  public void deleteHotelById(Long id) {
    Hotel hotel = hotelRepository.findByIdAndDeletedFalse(id)
            .orElseThrow(() -> new ElementNotFoundException("Could not find hotel with ID provided"));

    hotel.setDeleted(true);
    hotelRepository.save(hotel);
  }

  @Override
  public List<Hotel> searchHotelsByCityAndSortByDistance(Long cityId, String sortBy) {
    City city = cityRepository.findById(cityId)
            .orElseThrow(() -> new ElementNotFoundException("City not found"));

    List<Hotel> hotelsInCity = hotelRepository.findByCityAndDeletedFalse(city);

    if ("distance".equals(sortBy)) {
      hotelsInCity.sort(Comparator.comparingDouble(
              hotel -> calculateDistance(
                      hotel.getLatitude(),
                      hotel.getLongitude(),
                      city.getCityCentreLatitude(),
                      city.getCityCentreLongitude()
              )
      ));
    }


    return hotelsInCity.stream().limit(3).collect(Collectors.toList());
  }

  private double calculateDistance(double lat1, double lon1, double lat2, double lon2) {
    double R = 6371;
    double dLat = Math.toRadians(lat2 - lat1);
    double dLon = Math.toRadians(lon2 - lon1);
    double a = Math.sin(dLat / 2) * Math.sin(dLat / 2) +
            Math.cos(Math.toRadians(lat1)) * Math.cos(Math.toRadians(lat2)) *
                    Math.sin(dLon / 2) * Math.sin(dLon / 2);
    double c = 2 * Math.atan2(Math.sqrt(a), Math.sqrt(1 - a));
    return R * c;
  }
}
