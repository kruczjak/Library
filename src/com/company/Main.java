package com.company;

public class Main {

    public static void main(String[] args) {
        Library library = new Library();

        for (int i=0; i<20;i++) {
            new Reader(library, i).start();
        }

        for (int i=0;i<10;i++)  {
            new Writer(library, i).start();
        }
    }
}
