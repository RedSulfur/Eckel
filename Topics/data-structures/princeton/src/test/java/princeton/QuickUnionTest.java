package princeton;

import org.junit.Before;
import org.junit.Test;
import princeton.week1.QuickUnion;

import static org.hamcrest.Matchers.is;
import static org.junit.Assert.assertThat;

public class QuickUnionTest {

    private QuickUnion qu;

    @Before
    public void setUp() throws Exception {
        qu = new QuickUnion(10);
    }

    @Test
    public void shouldFindRootOfTheItem() {
        qu.union(3, 5);
        qu.union(5, 7);
        assertThat(qu.find(3), is(7));
    }
}