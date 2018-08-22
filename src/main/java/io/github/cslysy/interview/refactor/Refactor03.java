package io.github.cslysy.interview.refactor;

import org.junit.Test;

import static org.assertj.core.api.Assertions.assertThat;

public class Refactor03 {

    @Test
    public void switchValues() {
        // GIVEN
        int a = 3;
        int b = 5;

        // WHEN
        //write your code here...

        // THEN
        assertThat(a).isEqualTo(5);
        assertThat(b).isEqualTo(3);
    }
}
