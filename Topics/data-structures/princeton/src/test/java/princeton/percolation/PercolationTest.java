package princeton.percolation;

import org.junit.Before;
import org.junit.Rule;
import org.junit.Test;
import org.junit.rules.ExpectedException;

import static org.hamcrest.Matchers.is;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertThat;
import static org.junit.Assert.assertTrue;

public class PercolationTest {

    private Percolation percolation;

    @Rule
    public ExpectedException exception = ExpectedException.none();

    @Before
    public void setUp() throws Exception {
        percolation = new Percolation(4);
    }

    @Test
    public void shouldDetermineFullSite() {
        percolation.open(2, 2);
        percolation.open(3, 2);
        percolation.open(1, 4);
        percolation.open(2, 3);
        percolation.open(2, 4);

        percolation.open(4, 4);

        assertThat(percolation.isFull(3, 2), is(true));
        assertThat(percolation.isOpen(4, 4), is(true));
        assertThat(percolation.isFull(4, 4), is(false));
    }

    @Test
    public void shouldDetermineFullSite2() {
        percolation.open(1, 1);
        percolation.open(3, 1);
        percolation.open(2, 1);
        percolation.open(4, 2);
        percolation.open(4, 1);

        assertThat(percolation.isFull(4, 2), is(true));
        assertThat(percolation.isFull(2, 1), is(true));

        assertThat(percolation.isFull(3, 3), is(false));
    }

    @Test
    public void shouldFindRootOfTheUnitedElements() {
        percolation.open(3, 2);
        percolation.open(3, 2);
    }

    @Test
    public void shouldPercolateIfThereIsAVerticalPath() {
        percolation.open(1, 2);
        percolation.open(2, 2);
        percolation.open(3, 2);
        percolation.open(4, 2);

        assertThat(percolation.percolates(), is(true));
    }

    @Test
    public void shouldDetermineOpenedSite() {
        percolation.open(3, 2);
        percolation.open(2, 2);
        percolation.open(2, 3);

        assertTrue(percolation.isOpen(3, 2));
        assertTrue(percolation.isOpen(2, 2));
        assertTrue(percolation.isOpen(2, 3));

        assertThat(percolation.find(3, 2), is(5));
        assertThat(percolation.find(2, 2), is(5));
        assertThat(percolation.find(2, 3), is(5));
    }

    @Test
    public void shouldDetermineClosedSite() {
        assertFalse(percolation.isOpen(3, 2));
    }

    @Test
    public void shouldThrowAnErrorIfColIsOutOfBound() {
        exception.expect(IndexOutOfBoundsException.class);
        percolation.isOpen(4, 11);
    }

    @Test
    public void shouldThrowAnErrorIfRowIsOutOfBound() {
        exception.expect(IndexOutOfBoundsException.class);
        percolation.isOpen(11, 4);
    }

    @Test
    public void shouldThrowAnErrorIfRowsAndColsAreOutOfBound() {
        exception.expect(IndexOutOfBoundsException.class);
        percolation.isOpen(11, 11);
    }
    
    @Test
    public void shouldThrowErrorOnErroneousConstructorArgument() {
        exception.expect(IllegalArgumentException.class);
        exception.expectMessage("Some interstellar stuff is going on");
        new Percolation(-5);
    }
}