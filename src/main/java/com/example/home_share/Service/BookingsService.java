package com.example.home_share.Service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.home_share.Model.BookingsModel;
import com.example.home_share.Model.RoomsModel;
import com.example.home_share.Repo.BookingsRepo;

import jakarta.transaction.Transactional;

@Service
public class BookingsService {
    @Autowired
    private BookingsRepo bookRepo;

    public List<BookingsModel> myBookings(Integer userId) {
        return bookRepo.myBookings(userId);
    }

    @Transactional
    public BookingsModel bookMyRoom(BookingsModel book) {
        RoomsModel room = book.getRoomId();
        if (bookRepo.overLapping(book.getFrom(), book.getTo(), room.getRoomId()))
            return null;
        return bookRepo.save(book);
    }

    @Transactional
    public Optional<BookingsModel> cancelMyRoom(Integer id) {
        bookRepo.cancel(id);
        return bookRepo.findById(id);
    }
}
