package com.packers.service;

import java.util.List;

import com.packers.entity.Feedback;

public interface FeedbackService {

    Feedback addFeedback(Feedback feedback);

    List<Feedback> getAllFeedback();

    Feedback getFeedbackById(Long id);

    Feedback updateFeedback(Long id, Feedback feedback);

    void deleteFeedback(Long id);

    List<Feedback> getFeedbackByRating(Integer rating);

}