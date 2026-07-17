package com.packers.controller;

import java.util.List;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import com.packers.entity.Feedback;
import com.packers.service.FeedbackService;

@RestController
@RequestMapping("/api/feedback")
public class FeedbackController {

    private final FeedbackService service;

    public FeedbackController(FeedbackService service) {
        this.service = service;
    }

    // Add Feedback
    @PostMapping
    public ResponseEntity<Feedback> addFeedback(@RequestBody Feedback feedback) {
        return new ResponseEntity<>(service.addFeedback(feedback), HttpStatus.CREATED);
    }

    // Get All Feedback
    @GetMapping
    public ResponseEntity<List<Feedback>> getAllFeedback() {
        return ResponseEntity.ok(service.getAllFeedback());
    }

    // Get Feedback By Id
    @GetMapping("/{id}")
    public ResponseEntity<Feedback> getFeedbackById(@PathVariable Long id) {
        return ResponseEntity.ok(service.getFeedbackById(id));
    }

    // Update Feedback
    @PutMapping("/{id}")
    public ResponseEntity<Feedback> updateFeedback(@PathVariable Long id,
                                                   @RequestBody Feedback feedback) {
        return ResponseEntity.ok(service.updateFeedback(id, feedback));
    }

    // Delete Feedback
    @DeleteMapping("/{id}")
    public ResponseEntity<String> deleteFeedback(@PathVariable Long id) {

        service.deleteFeedback(id);

        return ResponseEntity.ok("Feedback Deleted Successfully");
    }

    // Search Feedback By Rating
    @GetMapping("/rating")
    public ResponseEntity<List<Feedback>> getFeedbackByRating(
            @RequestParam Integer rating) {

        return ResponseEntity.ok(service.getFeedbackByRating(rating));
    }
}