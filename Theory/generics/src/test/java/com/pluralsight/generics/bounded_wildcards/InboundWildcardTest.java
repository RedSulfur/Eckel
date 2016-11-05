package com.pluralsight.generics.bounded_wildcards;

import org.junit.Before;
import org.junit.Test;

import java.util.ArrayList;
import java.util.List;
import com.preparation.structures.queue.Queue;

import static org.hamcrest.Matchers.is;
import static org.junit.Assert.*;

public class InboundWildcardTest {

    private LowerBoundedWildcard lowerWildcard;
    private UpperBoundedWildcards upperWildcard;
    private Queue<Person> personQueue;

    @Before
    public void setUp() throws Exception {
        lowerWildcard = new LowerBoundedWildcard();
        upperWildcard = new UpperBoundedWildcards();
        personQueue = new Queue<>();
    }

    @Test
    public void listOfPersonsShouldBeSavedInQueue() {

        Partner john = new Partner("John Doe", 25);
        Partner jane = new Partner("Jane Doe", 30);

        List<Partner> persons = new ArrayList<>();

        persons.add(john);
        persons.add(jane);

        upperWildcard.putAll(persons, personQueue);

        assertThat(personQueue.dequeue(), is(john));
        assertThat(personQueue.dequeue(), is(jane));
    }

    @Test
    public void shouldPopulateUsersList() {
        Partner john = new Partner("John Doe", 25);
        Employee jane = new Employee("Jane Doe", 30);

        personQueue.enqueue(john);
        personQueue.enqueue(jane);

        List<Object> personList = new ArrayList<>();

        lowerWildcard.loadAll(personList, personQueue);
    }
}