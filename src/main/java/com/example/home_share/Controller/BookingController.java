package com.example.home_share.Controller;

import com.example.home_share.Model.BookingsModel;
import com.example.home_share.Service.BookingsService;

import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/bookings")
public class BookingController {

    private BookingsService bookingsService;

    public BookingController(BookingsService bookingsService) {
        this.bookingsService = bookingsService;
    }

    @GetMapping("/user/{userId}")
    public List<BookingsModel> getMyBookings(@PathVariable Integer userId) {
        return bookingsService.myBookings(userId);
    }

    @PostMapping("/book")
    public BookingsModel bookRoom(@RequestBody BookingsModel booking) {
        BookingsModel result = bookingsService.bookMyRoom(booking);
        if (result == null) {
            throw new IllegalArgumentException("Room is already booked for the selected dates.");
        }
        return result;
    }

    @PutMapping("/cancel/{id}")
    public Optional<BookingsModel> cancelBooking(@PathVariable Integer id) {
        return bookingsService.cancelMyRoom(id);
    }
}