package com.example.mvvm;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.arch.lifecycle.Observer;
import android.arch.lifecycle.ViewModelProviders;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.design.widget.FloatingActionButton;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import com.example.mvvm.model.Counter;
import com.example.mvvm.viewModel.CounterViewModel;

public class MainActivity extends AppCompatActivity {


    private CounterViewModel  viewM ;
    private TextView counterTextView ;
    private Button clickButton ;
    private  int counter ;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        counterTextView=findViewById(R.id.counterTextView);
        clickButton=findViewById(R.id.clickButton);

        viewM = ViewModelProviders.of(this).get(CounterViewModel.class);
        viewM.getCounter().observe(this, new Observer<Counter>() {

            @Override
            public void onChanged(@Nullable Counter model) {
                counter =model.getCounter();
                counterTextView.setText(counter+"");
            }
        });

        clickButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                counter++;
                viewM.getCounter().setValue(new Counter().setCounter(counter));
            }
        });
    }
}
