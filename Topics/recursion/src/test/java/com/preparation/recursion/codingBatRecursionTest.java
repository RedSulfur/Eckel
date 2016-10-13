package com.preparation.recursion;

import org.junit.Before;
import org.junit.Rule;
import org.junit.Test;
import org.junit.rules.ExpectedException;

import static org.hamcrest.Matchers.is;
import static org.junit.Assert.*;

public class codingBatRecursionTest {

    private CodingBatRecursion recursion;

    @Rule
    public ExpectedException expectedException = ExpectedException.none();

    @Before
    public void setUp() {
        recursion = new CodingBatRecursion();
    }

    @Test
    public void shouldCountEights()
            throws Exception {
        int result = recursion.count8(818);
        assertThat(result, is(2));
    }

    @Test
    public void shouldReturnZeroOnZeroInput()
            throws Exception {
        int result = recursion.count8(0);
        assertThat(result, is(0));
    }

    @Test
    public void shouldCountTwoNearbyEightsAsThree()
            throws Exception {
        int result = recursion.count8(8818);
        assertThat(result, is(4));
    }

    @Test
    public void shouldComputeNumberToNPower()
            throws Exception {
        int result = recursion.powerN(2, 12);
        assertThat(result, is(4096));
    }

    @Test
    public void shouldReturnZeroIfBaseIsZero()
            throws Exception {
        int result = recursion.powerN(0, 12);
        assertThat(result, is(0));
    }

    @Test
    public void shouldReturnOneIfPowerIsZero()
            throws Exception {
        int result = recursion.powerN(1024, 0);
        assertThat(result, is(1));
    }

    @Test
    public void shouldReturnOneIfBaseIsOneRegardlessWhatPowerItIs()
            throws Exception {
        int result = recursion.powerN(1, 1024);
        assertThat(result, is(1));
    }

    @Test
    public void shouldSubstituteXWithY() throws Exception {
        String result = recursion.changeXY("codex");
        assertThat(result, is("codey"));
    }
}