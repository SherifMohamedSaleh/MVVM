package com.example.mvvm.model;


import android.databinding.BaseObservable;

public class Counter extends BaseObservable {
    private int counter = 0;

    public int getCounter() {
        return counter;
    }

    public Counter setCounter(int counter) {
        this.counter = counter;
        return this;
    }
}
