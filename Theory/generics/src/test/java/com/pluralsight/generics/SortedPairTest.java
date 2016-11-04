package com.pluralsight.generics;

import org.junit.Test;

import static org.hamcrest.Matchers.is;
import static org.junit.Assert.assertThat;

public class SortedPairTest {

    @Test
    public void shouldAssignInTheSameOrderIfInputIsSorted() {
        SortedPair<Integer> sortedPair = new SortedPair<>(1, 2);
        assertThat(sortedPair.getLeft(), is(1));
        assertThat(sortedPair.getRight(), is(2));
    }
    
    @Test
    public void shouldReverseOrderIfInputIsNotSorted() {
        SortedPair<Integer> sortedPair = new SortedPair<>(2, 1);
        assertThat(sortedPair.getLeft(), is(1));
        assertThat(sortedPair.getRight(), is(2));
    }
}