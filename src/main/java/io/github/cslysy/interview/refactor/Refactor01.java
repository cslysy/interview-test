package io.github.cslysy.interview.refactor;

import org.junit.Test;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;

public class Refactor01 {

    private static final Logger logger = LoggerFactory.getLogger(Refactor01.class);

    public List<String> readFile(final String path) throws Exception {
        final List<String> lines = new ArrayList<>();
        FileInputStream fileInputStream = null;
        BufferedReader reader = null;
        try {
            fileInputStream = new FileInputStream(path);
            reader = new BufferedReader(new InputStreamReader(fileInputStream));
            String line = reader.readLine();
            while (line != null) {
                lines.add(line);
                line = reader.readLine();
            }
        } catch (Error e) {
            logger.error("Could not read file:" + path, e);
        } finally {
            reader.close();
            fileInputStream.close();
        }
        return lines;
    }

    @Test
    public void test() throws Exception {
        /*
         * GIVEN file contains two lines:
         * Ala ma kota
         * Piotr ma psa
         */
        final String path = "src/test/resources/refactor1.txt";

        // WHEN
        // write your code here...

        // THEN
        //write your code here...
    }
}
