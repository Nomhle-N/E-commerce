package cput.ac.za.ecommerce.controller;

import cput.ac.za.ecommerce.domain.Feedback;
import cput.ac.za.ecommerce.service.FeedbackService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
/*FeedbackController.java
    Controller for Feedback entity
    Author: Abulele Ntwanambi(218276400)
    Date: 12 July 2026 */

@RestController
@RequestMapping("/api/feedback")
public class FeedbackController {

    @Autowired
    private FeedbackService feedbackService;

    @PostMapping
    public Feedback create(@RequestBody Feedback feedback) {
        return feedbackService.create(feedback);
    }
    @GetMapping("/{feedbackId}")
    public Feedback read(@PathVariable String feedbackId) {
        return feedbackService.read(feedbackId);
    }
    @GetMapping
    public List<Feedback> getAll() {
        return feedbackService.getAll();
    }
    @PostMapping
    public Feedback update(@RequestBody Feedback feedback) {
        return feedbackService.update(feedback);
    }
    @DeleteMapping("/{feedbackId}")
    public void delete(@PathVariable String feedbackId) {
        feedbackService.delete(feedbackId);
    }


}
