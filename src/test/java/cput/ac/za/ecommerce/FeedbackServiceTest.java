package cput.ac.za.ecommerce;

import cput.ac.za.ecommerce.domain.Feedback;
import cput.ac.za.ecommerce.domain.ProductReview;
import cput.ac.za.ecommerce.repository.FeedbackRepository;
import cput.ac.za.ecommerce.service.impl.FeedbackServiceImpl;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import java.util.Arrays;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.mockito.Mockito.doNothing;
import static org.mockito.Mockito.when;
/*FeedbackServiceTest.java
    Test class for FeedbackService
    Author: Abulele Ntwanambi(218276400)
    Date: 12 July 2026 */

@ExtendWith(MockitoExtension.class)
public class FeedbackServiceTest {

    @Mock
    private FeedbackRepository feedbackRepository;

    @InjectMocks
    private FeedbackServiceImpl feedbackService;
private Feedback feedback;
    @BeforeEach
    void setUp() {

        feedback = new ProductReview.Builder()
                .setFeedbackId("F001")
                .setTargetProductId("P001")
                .setReviewerCustomerId("C001")
                .build();
    }

    @Test
    void create() {

        when(feedbackRepository.save(feedback)).thenReturn(feedback);

        Feedback created = feedbackService.create(feedback);

        assertNotNull(created);
        assertEquals("F001", created.getFeedbackId());


    }
    @Test
    void getAll() {

        List<Feedback> feedbackList = Arrays.asList(feedback);

        when(feedbackRepository.findAll()).thenReturn(feedbackList);

        List<Feedback> result = feedbackService.getAll();

        assertEquals(1, result.size());


    }
    @Test
    void delete() {

        doNothing().when(feedbackRepository).deleteById("F001");

        feedbackService.delete("F001");

    }
}
