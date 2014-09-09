package com.porch.interview;


import au.com.bytecode.opencsv.CSVReader;
import org.junit.Test;

import java.io.FileReader;
import java.io.IOException;
import java.net.URL;
import java.text.ParseException;

import static org.junit.Assert.assertEquals;

public class PorchInterviewTest {

    @Test
    public void testExample() throws IOException, ParseException {
        URL file = this.getClass().getResource("/reviews/10000");
        CSVReader reader = new CSVReader(new FileReader(file.getFile()), '\t');
        PorchInterview interview = new PorchInterview(reader);
        assertEquals(1, PorchInterview.getHighestRatedPro(interview.getReviews()));
    }
}
