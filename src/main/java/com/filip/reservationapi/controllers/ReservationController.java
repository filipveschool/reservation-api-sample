package com.filip.reservationapi.controllers;

import com.filip.reservationapi.models.Reservation;
import com.filip.reservationapi.services.ReservationService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/v1")
public class ReservationController {

    @Autowired
    private ReservationService reservationService;

    // ------------ Retrieve all reservations ------------
    @GetMapping(value = "/reservations", produces = MediaType.APPLICATION_JSON_UTF8_VALUE)
    public ResponseEntity getAllReservations() {
        return ResponseEntity.ok(reservationService.getAllReservations());
    }

    // ------------ Retrieve a reservation ------------
    @GetMapping(value = "/reservations/{id}", produces = MediaType.APPLICATION_JSON_UTF8_VALUE)
    public ResponseEntity getReservation(@PathVariable("id") Long id) {
        return ResponseEntity.ok(reservationService.getReservation(id));
    }

    // ------------ Create a reservation ------------
    @PostMapping(value = "/reservations", consumes = MediaType.APPLICATION_JSON_UTF8_VALUE)
    public void addReservation(@RequestBody Reservation reservation) {
        reservationService.addReservation(reservation);
    }

    // ------------ Update a reservation ------------
    @PutMapping(value = "/reservations/{id}", consumes = MediaType.APPLICATION_JSON_UTF8_VALUE)
    public void updateReservation(@RequestBody Reservation reservation, @PathVariable("id") Long id) {
        reservationService.updateReservation(id, reservation);
    }

    // ------------ Delete a reservation ------------
    @DeleteMapping("/reservations/{id}")
    public void deleteReservation(@PathVariable("id") Long id) {
        reservationService.deleteReservation(id);
    }


}
