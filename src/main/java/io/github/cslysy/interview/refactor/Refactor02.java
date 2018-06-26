package io.github.cslysy.interview.refactor;

import org.junit.Test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

public class Refactor02 {

    private static List<String> namesToUpperCase(final List<List<String>> families) {
        final List<String> result = new ArrayList<>();
        for (List<String> family : families) {
            for (String names : family) {
                if (names != null && !names.isEmpty()) {
                    result.add(names.toUpperCase());
                }
            }
        }
        return result;
    }

    @Test
    public void test() throws Exception {
        // given
        final List<String> firstFamily = Arrays.asList("john", "", "bob", "danny");
        final List<String> secondFamily = Arrays.asList("james", "peter", null, "laura");
        final List<List<String>> families = Arrays.asList(
            firstFamily, secondFamily
        );
    }
}
