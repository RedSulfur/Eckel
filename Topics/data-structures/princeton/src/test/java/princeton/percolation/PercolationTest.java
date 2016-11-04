package princeton.percolation;

import org.junit.Before;
import org.junit.Rule;
import org.junit.Test;
import org.junit.rules.ExpectedException;

public class PercolationTest {

    private Percolation percolation;

    @Rule
    public ExpectedException exception = ExpectedException.none();

    @Before
    public void setUp() throws Exception {
        percolation = new Percolation(10);
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
}