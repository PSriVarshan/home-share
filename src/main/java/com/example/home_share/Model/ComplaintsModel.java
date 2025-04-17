package com.example.home_share.Model;

import java.time.LocalDateTime;

import org.hibernate.annotations.CreationTimestamp;

import com.example.home_share.Model.Enums.ComplaintStatus;
import com.example.home_share.Model.Enums.ComplaintType;

import jakarta.persistence.Entity;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.OneToOne;

@Entity
public class ComplaintsModel {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer complaintId;

    @ManyToOne
    @JoinColumn(name = "userId", nullable = true)
    private UserModel against;
    @ManyToOne
    @JoinColumn(name = "hostId", nullable = true)
    private UserModel host;
    @Enumerated(EnumType.STRING)
    private ComplaintStatus status = ComplaintStatus.PENDING;
    @OneToOne
    @JoinColumn(name = "roomId", nullable = true)
    private RoomsModel roomId;
    private String title;
    @Enumerated(EnumType.STRING)
    private ComplaintType typeTag;
    private String description;

    public ComplaintsModel() {
    }

    public ComplaintsModel(Integer complaintId, UserModel against, UserModel host, ComplaintStatus status,
            RoomsModel roomId, String title, ComplaintType typeTag, String description, LocalDateTime postedAt) {
        this.complaintId = complaintId;
        this.against = against;
        this.host = host;
        this.status = status;
        this.roomId = roomId;
        this.title = title;
        this.typeTag = typeTag;
        this.description = description;
        this.postedAt = postedAt;
    }

    @CreationTimestamp
    private LocalDateTime postedAt;

    public Integer getComplaintId() {
        return complaintId;
    }

    public void setComplaintId(Integer complaintId) {
        this.complaintId = complaintId;
    }

    public UserModel getAgainst() {
        return against;
    }

    public void setAgainst(UserModel against) {
        this.against = against;
    }

    public UserModel getHost() {
        return host;
    }

    public void setHost(UserModel host) {
        this.host = host;
    }

    public ComplaintStatus getStatus() {
        return status;
    }

    public void setStatus(ComplaintStatus status) {
        this.status = status;
    }

    public RoomsModel getRoomId() {
        return roomId;
    }

    public void setRoomId(RoomsModel roomId) {
        this.roomId = roomId;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public ComplaintType getTypeTag() {
        return typeTag;
    }

    public void setTypeTag(ComplaintType typeTag) {
        this.typeTag = typeTag;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public LocalDateTime getPostedAt() {
        return postedAt;
    }

    public void setPostedAt(LocalDateTime postedAt) {
        this.postedAt = postedAt;
    }

}
