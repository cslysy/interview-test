package io.github.cslysy.interview.refactor;

import org.assertj.core.api.Assertions;
import org.junit.Test;

import static org.assertj.core.api.Assertions.assertThat;

public class Refactor03 {

    @Test
    public void switchValues(){
        //given
        int a = 3;
        int b = 5;

        //when
        //write your code there...

        //then
        assertThat(a).isEqualTo(5);
        assertThat(b).isEqualTo(3);
    }
}
