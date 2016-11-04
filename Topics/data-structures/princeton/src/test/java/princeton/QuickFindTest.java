package princeton;

import org.junit.Before;
import org.junit.Test;

import static org.hamcrest.Matchers.is;
import static org.junit.Assert.assertThat;
import static org.junit.Assert.assertTrue;

public class QuickFindTest {

    private QuickFind uf;

    @Before
    public void setUp() throws Exception {
        uf = new QuickFind(10);
    }

    @Test
    public void shouldConnectSitesOnUnion() {
        uf.union(3, 4);
        uf.union(3, 5);
        assertThat(uf.count(), is(8));
        assertTrue(uf.connected(3, 5));
        assertThat(uf.find(3), is(5));
    }

    @Test
    public void shouldNotDoAnythingIfItemsAreAlreadyConnected() {
        uf.union(3, 4);
        uf.union(3, 5);
        uf.union(3, 5);
        assertThat(uf.count(), is(8));
    }
}