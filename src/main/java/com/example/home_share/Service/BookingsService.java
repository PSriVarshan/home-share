package com.example.home_share.Service;

import java.util.List;

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

    public void cancelMyRoom(BookingsModel book) {
        bookRepo.delete(book);
    }

    public List<BookingsModel> listAllBookings(String pass) {
        String og = "123456789";
        if (pass.equals(og))
            return bookRepo.findAll();
        System.out.println("You ain't Admin Bro !!");
        return null;
    }
}
