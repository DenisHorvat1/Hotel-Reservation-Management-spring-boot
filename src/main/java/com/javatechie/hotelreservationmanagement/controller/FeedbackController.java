package com.javatechie.hotelreservationmanagement.controller;

import com.javatechie.hotelreservationmanagement.entity.Feedback;
import com.javatechie.hotelreservationmanagement.service.FeedbackService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/feedback")
public class FeedbackController {

    private final FeedbackService feedbackService;

    @Autowired
    public FeedbackController(FeedbackService feedbackService) {
        this.feedbackService = feedbackService;
    }

    @PostMapping
    public Feedback createFeedback(@RequestBody Feedback feedback) {
        return feedbackService.saveFeedback(feedback);
    }

    @GetMapping("/{id}")
    public Optional<Feedback> getFeedbackById(@PathVariable Long id) {
        return feedbackService.getFeedbackById(id);
    }

    @GetMapping
    public List<Feedback> getAllFeedback() {
        return feedbackService.getAllFeedback();
    }

    @DeleteMapping("/{id}")
    public void deleteFeedbackById(@PathVariable Long id) {
        feedbackService.deleteFeedbackById(id);
    }
}
