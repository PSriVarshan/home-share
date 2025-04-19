package com.example.home_share.Model;

import java.util.*;
import java.time.LocalDateTime;

import org.hibernate.annotations.CreationTimestamp;

import com.example.home_share.Model.Enums.BookingStatus;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import lombok.Data;

@Data
@Entity
public class BookingsModel {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer bookingId;
    @ManyToOne
    @JoinColumn(name = "roomId")
    private RoomsModel roomId;
    @ManyToOne
    @JoinColumn(name = "userId")
    private UserModel userId;
    private BookingStatus status = BookingStatus.BOOKED;
    @CreationTimestamp
    private LocalDateTime bookedDate;
    @Column(name = "start_date")
    private Date from;

    @Column(name = "end_date")
    private Date to;

    /*
     * @Scheduled(cron = "0 0 0 * * ?") // Runs daily at midnight
     * public void updateBookingStatuses() {
     * List<BookingsModel> bookings = bookRepo.findAll();
     * LocalDateTime now = LocalDateTime.now();
     * 
     * for (BookingsModel booking : bookings) {
     * if (booking.getTo().toInstant().isBefore(now.atZone(ZoneId.systemDefault()).
     * toInstant())
     * && booking.getStatus() == BookingStatus.BOOKED) {
     * booking.setStatus(BookingStatus.COMPLETED);
     * bookRepo.save(booking);
     * }
     * }
     * }
     */
}
