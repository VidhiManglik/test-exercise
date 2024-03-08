package com.booking.recruitment.hotel.controller;

import com.booking.recruitment.hotel.dto.HotelDTO;
import com.booking.recruitment.hotel.exception.ElementNotFoundException;
import com.booking.recruitment.hotel.model.Hotel;
import com.booking.recruitment.hotel.service.HotelService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/hotel")
public class HotelController {
    private final HotelService hotelService;

    @Autowired
    public HotelController(HotelService hotelService) {
        this.hotelService = hotelService;
    }

    @GetMapping
    @ResponseStatus(HttpStatus.OK)
    public List<Hotel> getAllHotels() {
        return hotelService.getAllHotels();
    }

    @GetMapping(value = "/{id}")
    public ResponseEntity<?> getHotelById(@PathVariable Long id) {
        try {
            HotelDTO hotel = hotelService.getHotelById(id);
            return ResponseEntity.ok(hotel);
        } catch (ElementNotFoundException e) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body(e.getMessage());
        }
    }

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public Hotel createHotel(@RequestBody Hotel hotel) {
        return hotelService.createNewHotel(hotel);
    }

    @DeleteMapping(value = "/{id}")
    public ResponseEntity<?> deleteHotelById(@PathVariable Long id) {
        try {
            hotelService.deleteHotelById(id);
            return ResponseEntity.ok("Hotel with ID " + id + " has been deleted");
        } catch (ElementNotFoundException e) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body(e.getMessage());
        }
    }

    @GetMapping("/search/{cityId}")
    public List<HotelDTO> searchHotelsByCityAndSortByDistance(
            @PathVariable Long cityId,
            @RequestParam(required = false) String sortBy
    ) {
        return hotelService.searchHotelsByCityAndSortByDistance(cityId, sortBy);
    }
}
