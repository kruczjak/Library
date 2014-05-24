package com.company;


/**
 * Created by kruczjak on 03.05.14.
 */
public class Library {
    private boolean writerIN = false;
    private int writersWaiting =0;
    private int readers=0;

    public void read(int i)  {
        synchronized (this) {
            while (writerIN||writersWaiting>0)  {
                try {
                    this.wait();
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
            readers++;
        }
        System.out.println(i+" Reading");
        try {
            Thread.sleep(1000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        synchronized (this) {
            readers--;
            notifyAll();
        }
    }

    public void write(int i) {
        synchronized (this) {
            writersWaiting++;
            while (readers>0 || writerIN) {
                try {
                    this.wait();
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }

            }

            writersWaiting--;
            writerIN=true;

        }
        System.out.println(i + " Saving");
        try {
            Thread.sleep(1000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        synchronized (this) {
            writerIN=false;
            notifyAll();
        }
    }
}
