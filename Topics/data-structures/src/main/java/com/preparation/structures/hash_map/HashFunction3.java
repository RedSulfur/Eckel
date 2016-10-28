package com.preparation.structures.hash_map;

import java.util.Scanner;

public class HashFunction3 {

    public String[][] elementsToAdd = {
            { "ace", "Very good" },
            { "act", "Take action" },
            { "add", "Join (something) to something else" },
            { "age", "Grow old" },
            { "ago", "Before the present" },
            { "aid", "Help, assist, or support" },
            { "aim", "Point or direct" },
            { "air", "Invisible gaseous substance" },
            { "all", "Used to refer to the whole quantity" },
            { "amp",
                    "Unit of measure for the strength of an electrical current" },
            { "and", "Used to connect words" }, { "ant", "A small insect" },
            { "any", "Used to refer to one or some of a thing" },
            { "ape", "A large primate" },
            { "apt", "Appropriate or suitable in the circumstances" },
            { "arc", "A part of the circumference of a curve" },
            { "are", "Unit of measure, equal to 100 square meters" },
            { "ark", "The ship built by Noah" },
            { "arm", "Two upper limbs of the human body" },
            { "art", "Expression or application of human creative skill" },
            { "ash", "Powdery residue left after the burning" },
            { "ask", "Say something in order to obtain information" },
            { "asp", "Small southern European viper" },
            { "ass", "Hoofed mammal" },
            { "ate", "To put (food) into the mouth and swallow it" },
            { "atm", "Unit of pressure" },
            { "awe", "A feeling of reverential respect" },
            { "axe", "Edge tool with a heavy bladed head" },
            { "aye", "An affirmative answer" } };

    private WordList[] arrray;
    int arraySize;

    public int stringHashFunction(String words) {

        int hashKeyValue = 0;

        for (int i = 0; i < words.length(); i++) {

            int charCode = words.charAt(i) - 97;

            int hashKVTemp = hashKeyValue;

            hashKeyValue = (hashKVTemp * 27 + charCode) % arraySize;
            System.out.println("Hash key value " + hashKVTemp + " * 27 + charCode "
                    + charCode + "% arraySize " + arraySize + " = " + hashKeyValue);
        }

        return hashKeyValue;
    }

    HashFunction3(int arraySize) {
        this.arraySize = arraySize;
        this.arrray = new WordList[arraySize];
        for (int i = 0; i < arraySize; i++) {
            arrray[i] = new WordList();
        }
        addTheArray(elementsToAdd);
    }

    public void addTheArray(String[][] elementsToAdd) {

        for (int i = 0; i < elementsToAdd.length; i++) {
            String word = elementsToAdd[i][0];
            String description = elementsToAdd[i][1];
            Word wordToAdd = new Word(word, description);
            insert(wordToAdd);
        }
    }

    public void insert(Word wordToAdd) {
        String wordToHash = wordToAdd.word;
        int hashKey = stringHashFunction(wordToHash);
        arrray[hashKey].insertIntoWordList(wordToAdd, hashKey);
    }

    public void display() {
        for (int i = 0; i < arraySize; i++) {
            arrray[i].display();
        }
    }

    public Word find(String wordToFind) {
        int hashKey = stringHashFunction(wordToFind);
        return arrray[hashKey].find(hashKey);
    }

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        HashFunction3 wordHashTable = new HashFunction3(11);
        String wordLookup = "a";

        while (!wordLookup.equals("x")) {
            wordLookup = in.nextLine();
            System.out.println(wordHashTable.find(wordLookup));
        }
        wordHashTable.display();
    }
}

class Word {

    public String word;
    public String definition;

    public Word next;

    public int key;

    public Word(String word, String definition) {
        this.word = word;
        this.definition = definition;
    }

    @Override
    public String toString() {
        return "Word{" +
                "word='" + word + '\'' +
                ", definition='" + definition + '\'' +
                '}';
    }
}

class WordList {

    private Word firstLink;

    public void insertIntoWordList(Word wordToInsert, int key) {

        Word previousLink = null;
        Word currentLink = firstLink;

        wordToInsert.key = key;

        while (currentLink != null && currentLink.key < wordToInsert.key) {
            previousLink = currentLink;
            currentLink = currentLink.next;
        }
        if(previousLink == null) {
            firstLink = wordToInsert;
        } else {
            previousLink.next = wordToInsert;
        }
        wordToInsert.next = currentLink;
    }

    public void display() {

        Word currentLink = firstLink;

        while (currentLink != null) {
            System.out.println(currentLink);
            currentLink = currentLink.next;
        }
    }

    public Word find(int key) {

        Word currentLink = firstLink;

        while (currentLink != null && currentLink.key <= key) {
            if (currentLink.key == key) {
                return currentLink;
            }
            currentLink = currentLink.next;
        }

        return null;
    }
}