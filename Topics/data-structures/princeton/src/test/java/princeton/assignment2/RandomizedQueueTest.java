package princeton.assignment2;

import org.junit.Before;
import org.junit.Rule;
import org.junit.Test;
import org.junit.rules.ExpectedException;

import java.util.NoSuchElementException;

import static org.hamcrest.Matchers.greaterThan;
import static org.hamcrest.Matchers.is;
import static org.hamcrest.Matchers.lessThan;
import static org.junit.Assert.assertThat;

public class RandomizedQueueTest {

    private RandomizedQueue<Integer> rq;

    @Rule public ExpectedException exception = ExpectedException.none();

    @Before
    public void setUp() throws Exception {
        rq = new RandomizedQueue<>();
    }

    @Test
    public void shouldRandomlyDequeueInsertedElements() {
        int low = 0;
        int high = 7;

        rq.enqueue(2);
        rq.enqueue(1);
        rq.enqueue(3);
        rq.enqueue(6);

        assertThat(rq.size(), is(4));
        assertThat(rq.dequeue(), is(greaterThan(low)));
        assertThat(rq.dequeue(), is(lessThan(high)));
        assertThat(rq.size(), is(2));
    }

    @Test
    public void shouldThrowAnErrorOnExtractingElementFromAnEmptyQueue() {
        exception.expect(NoSuchElementException.class);
        exception.expectMessage("You cannot dequeue from an empty queue");
    }
}