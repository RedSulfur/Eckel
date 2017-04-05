/*
package princeton.week2;

import org.junit.Before;
import org.junit.Test;

import java.util.Iterator;

import static org.hamcrest.Matchers.is;
import static org.junit.Assert.assertThat;

public class ResizableArrayStackTest {

    private ResizableArrayStack<String> arrayStack;

    @Before
    public void setUp() throws Exception {
        arrayStack = new ResizableArrayStack<>();
    }

    @Test
    public void shouldPopElementOnNonEmptyStack() {
        arrayStack.push("John");
        arrayStack.push("Doe");

        assertThat(arrayStack.pop(), is("Doe"));
        assertThat(arrayStack.pop(), is("John"));
    }

    @Test
    public void shouldReturnCorrectSizeOfTheStack() {
        arrayStack.push("John");
        arrayStack.push("Doe");

        assertThat(arrayStack.size(), is(2));
    }

    @Test
    public void iteratorShouldIterateElementsOfTheStack() {
        arrayStack.push("John");
        Iterator<String> stackIterator = arrayStack.iterator();
        String elementInStack = null;
        while (stackIterator.hasNext()) {
            elementInStack = stackIterator.next();
        }
        assertThat(elementInStack, is("John"));
    }
}*/
