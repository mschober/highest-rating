package com.porch.interview;


import au.com.bytecode.opencsv.CSVReader;
import org.junit.Before;
import org.junit.Test;

import java.io.FileReader;
import java.io.IOException;
import java.net.URL;
import java.text.ParseException;

import static org.junit.Assert.assertEquals;

public class PorchInterviewTest {

    private PorchInterview pi;

    @Before
    public void setUp() throws IOException, ParseException {
        URL file = this.getClass().getResource("/reviews/reviews");
        CSVReader reader = new CSVReader(new FileReader(file.getFile()), '\t');
        String[] header = reader.readNext();
        this.pi = new PorchInterview(reader.readAll());
    }

    @Test
    public void testCountReviews() throws IOException, ParseException {
        assertEquals(10, PorchInterview.countReviews(this.pi.getReviews()));
    }
}
