package com.example.home_share.Repo;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.example.home_share.Model.RoomsModel;

@Repository
public interface RoomsRepo extends JpaRepository<RoomsModel, Integer> {
    @Query("SELECT r FROM RoomsModel r WHERE r.price < :pp AND r.hostId.address.city = :inputCity")
    List<RoomsModel> listRoomsByPrice(@Param("pp") Double pp,
            @Param("inputCity") String inputCity);

    @Query("SELECT r FROM RoomsModel r WHERE r.hostId.address.city = :inputCity")
    List<RoomsModel> listRooms(@Param("inputCity") String inputCity);

    @Modifying
    @Transactional
    @Query("UPDATE RoomsModel r SET r.availabilty = :avl WHERE r.roomId=:id")
    int updateAvl(@Param("avl") Boolean avl,
            @Param("id") Integer id);
}
