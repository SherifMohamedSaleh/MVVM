package com.example.mvvm.viewModel;

import android.arch.lifecycle.MutableLiveData;

import android.arch.lifecycle.ViewModel;

import com.example.mvvm.model.Counter;


public  class CounterViewModel extends ViewModel {
    private MutableLiveData<Counter> counter;

    public MutableLiveData<Counter>getCounter(){
        if(counter==null)
            counter=new MutableLiveData<Counter>();
        return  counter;
    }
}
