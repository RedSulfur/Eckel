package princeton;

import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.*;

public class WeightedQuickUnionTest {

    private WeightedQuickUnion wqu;

    @Before
    public void setUp() throws Exception {
        wqu = new WeightedQuickUnion(10);
    }

    @Test
    public void unknown() {
        wqu.union(4, 3);
        wqu.union(4, 5);


    }
}