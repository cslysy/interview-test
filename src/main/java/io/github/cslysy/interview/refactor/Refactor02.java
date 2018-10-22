package io.github.cslysy.interview.refactor;

import org.assertj.core.api.Assertions;
import org.junit.Test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;
import java.util.List;
import java.util.stream.Collectors;

import static org.assertj.core.api.Assertions.assertThat;

public class Refactor02 {

    private static List<String> namesToUpperCase(final List<List<String>> families) {

        return families.stream()
                .flatMap(Collection::stream)
                .filter(x -> x != null)
                .filter(x -> x != "")
                .map(x -> x.toUpperCase())
                .collect(Collectors.toList());
    }

    @Test
    public void test() throws Exception {
        // GIVEN
        final List<String> firstFamily = Arrays.asList("john", "", "bob", "danny");
        final List<String> secondFamily = Arrays.asList("james", "peter", null, "laura");
        final List<List<String>> families = Arrays.asList(
                firstFamily, secondFamily
        );

        // WHEN
        List<String> actual = Refactor02.namesToUpperCase(families);

        // THEN
        assertThat(actual).containsExactly("JOHN", "BOB", "DANNY", "JAMES", "PETER", "LAURA");

        //fibonacci, silnia
        //zozonosc obliczeniaowa Big O notation

    }
}
