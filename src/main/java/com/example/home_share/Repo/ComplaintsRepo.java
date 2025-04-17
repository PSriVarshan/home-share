package com.example.home_share.Repo;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.example.home_share.Model.ComplaintsModel;
import com.example.home_share.Model.Enums.ComplaintStatus;

@Repository
public interface ComplaintsRepo extends JpaRepository<ComplaintsModel, Integer> {

    @Query("SELECT c FROM ComplaintsModel c WHERE c.roomId=:roomId")
    List<ComplaintsModel> listComplaintsByRoomId(@Param("roomId") Integer roomId);

    @Query("SELECT c FROM ComplaintsModel c WHERE c.against.userId =:guestId")
    List<ComplaintsModel> listComplaintsByGuestId(@Param("guestId") Integer guestId);

    @Modifying
    @Transactional
    @Query("UPDATE ComplaintsModel c SET c.status =:newStatus WHERE c.complaintId=:cId")
    int updateComplaintStatus(@Param("newStatus") ComplaintStatus newStatus,
            @Param("cId") Integer cId);
}
