package com.packers.entity;

import jakarta.persistence.*;
import lombok.Data;

@Data
@Entity
@Table(name = "feedback")
public class Feedback {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long feedbackId;

    // Customer who gave the feedback
    @ManyToOne
    @JoinColumn(name = "user_id")
    private User user;

    // Service for which feedback is given
    @ManyToOne
    @JoinColumn(name = "service_id")
    private MovingService movingService;

    @Column(length = 1000)
    private String comments;

    private Integer rating;   // 1 to 5

    private String status;    // ACTIVE / HIDDEN
}