package com.porch.interview;


import au.com.bytecode.opencsv.CSVReader;
import org.apache.commons.io.FileUtils;
import org.junit.Test;

import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.net.URL;
import java.util.Arrays;
import java.util.List;

import static org.junit.Assert.assertEquals;

public class PorchInterviewTest {

    @Test
    public void testExample() throws IOException {
        assertEquals(1, 1);
        URL file = this.getClass().getResource("/reviews/1");
        CSVReader reader = new CSVReader(new FileReader(file.getFile()), '\t');
        String[] header = reader.readNext();
        List<String[]> values = reader.readAll();
        System.out.println(Arrays.toString(header));
        for(String[] line : values){
            System.out.println(Arrays.toString(line));
        }
        assertEquals(1, values.size());
    }
}
