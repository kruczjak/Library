package com.company;

/**
 * Created by kruczjak on 03.05.14.
 */
public class Writer extends Thread{
    private final Library library;
    private final int i;
    public Writer(Library library, int i) {
        this.library = library;
        this.i = i;
    }

    @Override
    public void run() {
        while (true)    {
            library.write(i);
        }
    }
}
