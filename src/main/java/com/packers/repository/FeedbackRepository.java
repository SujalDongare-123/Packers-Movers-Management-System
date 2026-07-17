package com.packers.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.packers.entity.Feedback;

public interface FeedbackRepository extends JpaRepository<Feedback, Long> {

    List<Feedback> findByRating(Integer rating);

}