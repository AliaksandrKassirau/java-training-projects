package com.epam.memory;

public class ReadinessConditionApplication {

    public static void main(String[] args) {
        Book novel = new Book(true);
        novel.checkIn();

        //new Book(true);

        System.gc();
    }
}

class Book {
    private boolean checkedOut = false;
    Book(boolean checkOut) {
        checkedOut = checkOut;
    }

    void checkIn() {
        checkedOut = false;
    }

    public void finalize() {
        if (checkedOut) {
            System.out.println("Error: checkOut");
        }
    }
}