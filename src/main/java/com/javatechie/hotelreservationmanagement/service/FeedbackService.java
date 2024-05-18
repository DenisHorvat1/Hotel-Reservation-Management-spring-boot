package com.javatechie.hotelreservationmanagement.service;

import com.javatechie.hotelreservationmanagement.entity.Feedback;
import com.javatechie.hotelreservationmanagement.repository.FeedbackRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class FeedbackService {

    private final FeedbackRepository feedbackRepository;

    @Autowired
    public FeedbackService(FeedbackRepository feedbackRepository) {
        this.feedbackRepository = feedbackRepository;
    }

    public Feedback saveFeedback(Feedback feedback) {
        return feedbackRepository.save(feedback);
    }

    public Optional<Feedback> getFeedbackById(Long id) {
        return feedbackRepository.findById(id);
    }

    public List<Feedback> getAllFeedback() {
        return feedbackRepository.findAll();
    }

    public void deleteFeedbackById(Long id) {
        feedbackRepository.deleteById(id);
    }
}
