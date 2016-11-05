package princeton;

import org.junit.Before;
import org.junit.Test;

public class WeightedQuickUnionTest {

    private WeightedQuickUnionUF wqu;

    @Before
    public void setUp() throws Exception {
        wqu = new WeightedQuickUnionUF(10);
    }

    @Test
    public void unknown() {
        wqu.union(4, 3);
        wqu.union(4, 5);
    }
}