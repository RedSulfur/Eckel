package princeton.deque;

import org.junit.Before;
import org.junit.Rule;
import org.junit.Test;
import org.junit.rules.ExpectedException;
import princeton.assignment2.Deque;

import java.util.NoSuchElementException;

import static org.hamcrest.Matchers.is;
import static org.junit.Assert.assertThat;

public class DequeTest {

    private Deque<Integer> deque;

    @Rule public ExpectedException exception = ExpectedException.none();

    @Before
    public void setUp() throws Exception {
        deque = new Deque<>();
    }

    @Test
    public void shouldAddInLastPosition() {
        deque.addLast(2);
        deque.addLast(3);
        deque.addLast(1);

        assertThat(deque.removeLast(), is(1));
        assertThat(deque.removeLast(), is(3));
        assertThat(deque.removeLast(), is(2));
    }

    @Test
    public void shouldThrowExceptionOnRemovingLastElementFromEmptyDeque() {
        exception.expect(NoSuchElementException.class);
        exception.expectMessage("You cannot remove items from empty deque");

        deque.removeLast();
    }

    @Test
    public void shouldAddInFirstPosition() {
        deque.addFirst(2);
        deque.addFirst(3);

        assertThat(deque.removeFirst(), is(3));
        assertThat(deque.removeFirst(), is(2));
    }

    @Test
    public void shouldThrowExceptionOnRemovingFirstElementFromEmptyDeque() {
        exception.expect(NoSuchElementException.class);
        exception.expectMessage("You cannot remove items from empty deque");

        deque.removeFirst();
    }

    @Test
    public void shouldAddElementsInBothEnds() {
        deque.addFirst(2);
        deque.addLast(3);
        deque.addFirst(1);

        assertThat(deque.removeLast(), is(3));
        deque.addLast(4);
        assertThat(deque.removeLast(), is(4));
        assertThat(deque.removeFirst(), is(1));
        assertThat(deque.removeFirst(), is(2));
    }

    @Test
    public void shouldRemoveFromFirstPositionIfElementsWereAddedInLast() {
        deque.addLast(3);
        deque.addLast(2);
        deque.addLast(5);

        assertThat(deque.removeFirst(), is(3));
        assertThat(deque.removeFirst(), is(2));
        assertThat(deque.removeFirst(), is(5));
    }

    @Test
    public void shouldRemoveFromLastPositionIfElementsWereAddedInFirst() {
        deque.addFirst(3);
        deque.addFirst(2);
        deque.addFirst(5);

        assertThat(deque.removeLast(), is(3));
        assertThat(deque.removeLast(), is(2));
        assertThat(deque.removeLast(), is(5));
    }

    @Test
    public void shouldChangeSizeOnRemovingElements() {
        deque.addFirst(2);
        deque.addLast(3);
        deque.addFirst(1);

        assertThat(deque.size(), is(3));
        assertThat(deque.removeLast(), is(3));
        assertThat(deque.size(), is(2));
        deque.addLast(4);
        assertThat(deque.size(), is(3));
        assertThat(deque.removeLast(), is(4));
        assertThat(deque.size(), is(2));
        assertThat(deque.removeFirst(), is(1));
        assertThat(deque.size(), is(1));
        assertThat(deque.removeFirst(), is(2));
        assertThat(deque.size(), is(0));
    }
}