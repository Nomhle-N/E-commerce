package cput.ac.za.ecommerce.service.impl;

import cput.ac.za.ecommerce.domain.Feedback;

import java.util.List;

public interface IFeedback {
    Feedback create(Feedback feedback);
    Feedback read(String feedbackId);
    List<Feedback> getAll();
    Feedback update(Feedback feedback);
    void delete(String feedbackId);
}
