package com.company;

/**
 * Created by kruczjak on 03.05.14.
 */
public class Reader extends Thread {
    private final Library library;
    private final int i;

    public Reader(Library library, int i) {
        this.library = library;
        this.i=i;
    }

    @Override
    public void run() {
        while (true)    {
            library.read(i);
        }
    }
}
