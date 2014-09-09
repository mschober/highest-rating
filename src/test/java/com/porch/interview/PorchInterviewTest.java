package com.porch.interview;


import au.com.bytecode.opencsv.CSVReader;
import org.junit.Ignore;
import org.junit.Test;

import java.io.FileReader;
import java.io.IOException;
import java.net.URL;
import java.text.ParseException;

import static com.porch.interview.PorchInterview.countReviews;
import static com.porch.interview.PorchInterview.getHighestRatedPro;
import static org.junit.Assert.assertEquals;

public class PorchInterviewTest {

    private PorchInterview readReviewsList(String reviewFileName) throws IOException, ParseException {
        URL file = this.getClass().getResource("/reviews/" + reviewFileName);
        CSVReader reader = new CSVReader(new FileReader(file.getFile()), '\t');
        //String[] header = reader.readNext();
        return new PorchInterview(reader.readAll());
    }

    @Ignore
    @Test
    public void testCountReviews() throws IOException, ParseException {
        PorchInterview pi = readReviewsList("random_reviews.tsv");
        assertEquals(100000, countReviews(pi.getReviews()));
    }

    @Test
    public void testSingleReview() throws IOException, ParseException {
        PorchInterview pi = readReviewsList("single_review.tsv");
        assertEquals(9000, getHighestRatedPro(pi.getReviews()));
    }

    @Test
    public void testHighestAverage() throws IOException, ParseException {
        PorchInterview pi = readReviewsList("highest_average_review.tsv");
        assertEquals(9001, getHighestRatedPro(pi.getReviews()));
    }

    @Test
    public void testLargeSet() throws IOException, ParseException {
        PorchInterview pi = readReviewsList("random_reviews.tsv");
        assertEquals(3444, getHighestRatedPro(pi.getReviews()));
    }
}
