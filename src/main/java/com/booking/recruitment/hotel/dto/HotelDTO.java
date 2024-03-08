package com.booking.recruitment.hotel.dto;

import com.booking.recruitment.hotel.model.City;

public class HotelDTO {
    private Long id;
    private String name;
    private Double rating;
    private City city;
    private String address;
    private double latitude;
    private double longitude;

    public HotelDTO() {
    }

    public HotelDTO(Long id, String name, Double rating, City city, String address, double latitude, double longitude) {
        this.id = id;
        this.name = name;
        this.rating = rating;
        this.city = city;
        this.address = address;
        this.latitude = latitude;
        this.longitude = longitude;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Double getRating() {
        return rating;
    }

    public void setRating(Double rating) {
        this.rating = rating;
    }

    public City getCity() {
        return city;
    }

    public void setCity(City city) {
        this.city = city;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public double getLatitude() {
        return latitude;
    }

    public void setLatitude(double latitude) {
        this.latitude = latitude;
    }

    public double getLongitude() {
        return longitude;
    }

    public void setLongitude(double longitude) {
        this.longitude = longitude;
    }
}
