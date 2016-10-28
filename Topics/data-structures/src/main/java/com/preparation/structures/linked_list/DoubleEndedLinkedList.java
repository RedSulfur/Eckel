package com.preparation.structures.linked_list;

public class DoubleEndedLinkedList {

    public Neighbour lastLink;
    public Neighbour firstLink;

    public boolean isEmpty() {
        return firstLink == null;
    }

    class Neighbour {

        private String homeOwnerName;
        private int houseNumber;

        public Neighbour next;
        public Neighbour previous;

        public Neighbour(String homeOwnerName, int houseNumber) {
            this.homeOwnerName = homeOwnerName;
            this.houseNumber = houseNumber;
        }

        public void display() {
            System.out.println(homeOwnerName + " " + houseNumber);
        }

        @Override
        public String toString() {
            return homeOwnerName;
        }
    }

    public void display() {

        Neighbour theLink = firstLink;
        while (theLink != null) {
            theLink.display();
            System.out.println("Previous link: " + theLink.previous);
            System.out.println("Next link: " + theLink.next);
            theLink = theLink.next;
            System.out.println();
        }
    }

    public static void main(String[] args) {

        DoubleEndedLinkedList theLinkedList = new DoubleEndedLinkedList();
        theLinkedList.insertInOrder("Mark Evans", 7);
        theLinkedList.insertInOrder("Derek Doe", 9);
        theLinkedList.insertInOrder("James Fehn", 8);
        theLinkedList.insertInOrder("James Paulsen", 4);
        theLinkedList.display();
    }

    public void insertInOrder(String homeOwnerName, int houseNumber) {
        Neighbour theNewLink = new Neighbour(homeOwnerName, houseNumber);

        Neighbour previousNeighbor = null;
        Neighbour currentNeighbor = firstLink;

        while ((currentNeighbor != null) && (houseNumber > currentNeighbor.houseNumber)){
            previousNeighbor = currentNeighbor;
            currentNeighbor = currentNeighbor.next; // Get the next Neighbor
        }
        if (previousNeighbor == null) {
            firstLink = theNewLink;
        } else {
            previousNeighbor.next = theNewLink;
            theNewLink.previous = previousNeighbor;
            if (currentNeighbor != null)
            currentNeighbor.previous = theNewLink;
        }
        theNewLink.next = currentNeighbor;
    }

    public boolean insertAfterKey(String homeOwnerName, int houseNumber, int key) {

        Neighbour newNeighbour = new Neighbour(homeOwnerName, houseNumber);
        Neighbour theNeighbour = firstLink;

        while (theNeighbour.houseNumber != key) {
            theNeighbour = theNeighbour.next;
            if (theNeighbour == null) return false;
        }
        if (theNeighbour == lastLink) {
            newNeighbour.next = null;
            lastLink = newNeighbour;
        } else {
            newNeighbour.next = theNeighbour.next;
            theNeighbour.next.previous = newNeighbour;
        }
        newNeighbour.previous = theNeighbour;
        theNeighbour.next = newNeighbour;
        return true;
    }

    public void insertInFirstPosition(String homeOwnerName, int houseNumber) {

        Neighbour newNeighbour = new Neighbour(homeOwnerName, houseNumber);

        if (isEmpty()) {
            lastLink = newNeighbour;
        } else {
            firstLink.previous = newNeighbour;
        }

        newNeighbour.next = firstLink;
        firstLink = newNeighbour;
    }

    public void insertInLastPosition(String homeOwnerName, int houseNumber) {

        Neighbour newNeighbour = new Neighbour(homeOwnerName, houseNumber);

        if (isEmpty()) {
            firstLink = newNeighbour;
        } else {
            newNeighbour.previous = lastLink;
            lastLink.next = newNeighbour;
        }
        lastLink = newNeighbour;
    }

    static class NeighbourIterator {

        Neighbour currentNeighbour;
        Neighbour previousNeighbour;
        DoubleEndedLinkedList neighbours;

        public NeighbourIterator(DoubleEndedLinkedList linkedList) {

            this.neighbours = linkedList;
            currentNeighbour = linkedList.firstLink;
            previousNeighbour = linkedList.lastLink;
        }

        public boolean hasNext() {
            return currentNeighbour.next != null;
        }

        public Neighbour next() {

            if(hasNext()) {
                previousNeighbour = currentNeighbour;
                currentNeighbour = currentNeighbour.next;
                return currentNeighbour;
            }
            return null;
        }

        public void remove() {
            if (previousNeighbour == null) {
                neighbours.firstLink = currentNeighbour.next;
            } else {
                previousNeighbour.next = currentNeighbour.next;

                if (currentNeighbour.next == null) {
                    currentNeighbour = neighbours.firstLink;
                    previousNeighbour = null;
                } else {
                    currentNeighbour = currentNeighbour.next;
                }
            }
        }
    }
}
//
//        theLinkedList.insertAfterKey("Kourtney Stark", 5, 4);
//        System.out.println();

//        NeighbourIterator iterator = new NeighbourIterator(theLinkedList);

//        iterator.currentNeighbour.display();
//        System.out.println(iterator.hasNext());
//        iterator.next();
//        iterator.currentNeighbour.display();
//        iterator.remove();
//        iterator.currentNeighbour.display();
//
//        theLinkedList.display();

//if(currentLink != null) {
//        currentLink.previous = newNeighbour;
//        }