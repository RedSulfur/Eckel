package com.pluralsight.generics;

import org.junit.Before;
import org.junit.Test;

import static org.hamcrest.Matchers.is;
import static org.hamcrest.Matchers.nullValue;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertThat;
import static org.junit.Assert.assertTrue;

public class QueueTest {

    private Queue queue;

    @Before
    public void setUp() throws Exception {
        queue = new Queue(2);
    }

    @Test
    public void shouldOfferPollableItem() {
        assertTrue(queue.offer(1));
        assertTrue(queue.offer(2));
        Object value = queue.poll();

        assertThat(value, is(1));
    }
    
    @Test
    public void shouldNotOfferWhenBufferIsFull() {
        assertTrue(queue.offer(1));
        assertTrue(queue.offer(2));
        assertFalse(queue.offer(3));
    }
    
    @Test
    public void shouldNotPollWhenBufferIsEmpty() {
        assertThat(queue.poll(), is(nullValue()));
    }
    
    @Test
    public void shouldRecycleBuffer() {
        queue.offer(2);
        queue.offer(3);
        assertThat(queue.poll(), is(2));
        queue.offer(1);
        assertThat(queue.poll(), is(3));
        assertThat(queue.poll(), is(1));
    }
}