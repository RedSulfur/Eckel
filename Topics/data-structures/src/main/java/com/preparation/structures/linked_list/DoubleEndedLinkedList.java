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
            System.out.println("Next link: " + theLink.next);
            theLink = theLink.next;
            System.out.println();
        }
    }

    public static void main(String[] args) {

        DoubleEndedLinkedList theLinkedList = new DoubleEndedLinkedList();
        theLinkedList.insertInOrder("Mark Evans", 7);
        theLinkedList.insertInOrder("John Doe", 9);
        theLinkedList.insertInOrder("Kali Linux", 6);
        theLinkedList.insertInOrder("Mark Poulson", 4);

        theLinkedList.insertAfterKey("Kourtney Stark", 5, 4);

        theLinkedList.display();

        System.out.println();

        NeighbourIterator iterator = new NeighbourIterator(theLinkedList);

        iterator.currentNeighbour.display();
        System.out.println(iterator.hasNext());
        iterator.next();
        iterator.currentNeighbour.display();
        iterator.remove();
        iterator.currentNeighbour.display();

        theLinkedList.display();
    }

    public void insertInOrder(String homeOwnerName, int houseNumber) {

        Neighbour newNeighbour = new Neighbour(homeOwnerName, houseNumber);

        Neighbour currentLink = firstLink;
        Neighbour previousLink = null;

        while (currentLink != null && currentLink.houseNumber < houseNumber) {
            previousLink = currentLink;
            currentLink = currentLink.next;
        }
        if(previousLink == null) {
            firstLink = newNeighbour;
        } else {
            previousLink.next = newNeighbour;
        }
        newNeighbour.next = currentLink;
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

            if(previousNeighbour == null) {
                neighbours.firstLink = currentNeighbour.next;
            } else {
                previousNeighbour.next = currentNeighbour.next;
                if(currentNeighbour.next == null) {
                    currentNeighbour = neighbours.firstLink;
                    previousNeighbour = null;
                } else {
                    currentNeighbour = currentNeighbour.next;
                }
            }
        }
    }
}

