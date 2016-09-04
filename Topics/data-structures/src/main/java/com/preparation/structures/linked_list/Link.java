package com.preparation.structures.linked_list;

public class Link {

    String bookName;
    int millionsSold;

    Link next;

    public Link(String bookName, int millionsSold) {
        this.bookName = bookName;
        this.millionsSold = millionsSold;
    }

    public void display() {
        System.out.println("bookName: " + this.bookName
                + ", millions Sold: " + this.millionsSold);
    }

    @Override
    public String toString() {
        return bookName;
    }

    public static void main(String[] args) {

        LinkList linkList = new LinkList();

        linkList.insertTheFirstLink("Don Quixote", 500);
        linkList.insertTheFirstLink("A Tale of Two Cities", 200);
        linkList.insertTheFirstLink("The lord of the rings", 150);
        linkList.insertTheFirstLink("Harry Potter", 100);

        linkList.removeFirst();

        linkList.display();
        System.out.println(linkList.find("Don Quixote").bookName + " was found");

        System.out.println("AFTER DELETION OF DON QUIXOTE");
        System.out.println();
        linkList.removeLink("Don Quixote");
        linkList.display();
    }

}

class LinkList {

    Link firstLink;

    LinkList() {
        firstLink = null;
    }

    public boolean isEmpty() {
        return (firstLink == null);
    }

    public void insertTheFirstLink(String bookName, int millionsSold) {

        Link newLink = new Link(bookName, millionsSold);

        newLink.next = firstLink;
        firstLink = newLink;

    }

    public Link removeFirst() {

        Link removed = firstLink;

        if(!isEmpty()) {
            firstLink = firstLink.next;
        } else {
            System.out.println("List is empty!");
        }
        return removed;
    }

    public void display() {

        Link lastLink = firstLink;

        while (lastLink != null) {
            lastLink.display();
            System.out.println("Next Link: " + lastLink.next);
            lastLink = lastLink.next;
            System.out.println();
        }
    }

    public Link find(String bookName) {

        Link theLink = firstLink;

        if(!isEmpty()) {
            while (theLink.bookName != bookName) {
                if (theLink.next == null) {
                    return null;
                } else {
                    theLink = theLink.next;
                }
            }
            System.out.println("Empty linkedList");
        }

        return theLink;
    }

    public Link removeLink(String bookName) {

        Link currentLink = firstLink;
        Link previousLink = firstLink;

        while (currentLink.bookName != bookName) {
            if(currentLink.next == null) {
                return null;
            } else {
                previousLink = currentLink;
                currentLink = currentLink.next;
            }
        }

        if(currentLink == firstLink) {

            firstLink = firstLink.next;
        } else {
            previousLink.next = currentLink.next;
        }

        return currentLink;
    }
}