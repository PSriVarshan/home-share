package com.example.home_share.Repo;

import java.util.*;
import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.example.home_share.Model.BookingsModel;

@Repository
public interface BookingsRepo extends JpaRepository<BookingsModel, Integer> {

        @Query("SELECT b FROM BookingsModel b WHERE b.userId.userId =:uId")
        List<BookingsModel> myBookings(@Param("uId") Integer uId);

        @Query("SELECT CASE WHEN COUNT(b) > 0 THEN true ELSE false END FROM BookingsModel b WHERE b.roomId.roomId = :roomId AND b.status = com.example.home_share.Model.Enums.BookingStatus.BOOKED AND (b.from <= :to AND b.to >= :from)")
        Boolean overLapping(@Param("from") Date from, @Param("to") Date to, @Param("roomId") Integer roomId);
}
