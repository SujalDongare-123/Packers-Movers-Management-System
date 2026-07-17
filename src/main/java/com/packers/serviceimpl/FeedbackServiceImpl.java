package com.packers.serviceimpl;

import java.util.List;

import org.springframework.stereotype.Service;

import com.packers.entity.Feedback;
import com.packers.repository.FeedbackRepository;
import com.packers.service.FeedbackService;

@Service
public class FeedbackServiceImpl implements FeedbackService {

    private final FeedbackRepository repository;

    public FeedbackServiceImpl(FeedbackRepository repository) {
        this.repository = repository;
    }

    @Override
    public Feedback addFeedback(Feedback feedback) {
        return repository.save(feedback);
    }

    @Override
    public List<Feedback> getAllFeedback() {
        return repository.findAll();
    }

    @Override
    public Feedback getFeedbackById(Long id) {

        return repository.findById(id)
                .orElseThrow(() -> new RuntimeException("Feedback Not Found"));
    }

    @Override
    public Feedback updateFeedback(Long id, Feedback feedback) {

        Feedback existing = repository.findById(id)
                .orElseThrow(() -> new RuntimeException("Feedback Not Found"));

        existing.setUser(feedback.getUser());
        existing.setMovingService(feedback.getMovingService());
        existing.setComments(feedback.getComments());
        existing.setRating(feedback.getRating());
        existing.setStatus(feedback.getStatus());

        return repository.save(existing);
    }

    @Override
    public void deleteFeedback(Long id) {

        Feedback feedback = repository.findById(id)
                .orElseThrow(() -> new RuntimeException("Feedback Not Found"));

        repository.delete(feedback);
    }

    @Override
    public List<Feedback> getFeedbackByRating(Integer rating) {
        return repository.findByRating(rating);
    }
}