package com.example.smeredith.sumcalculator;

import android.app.Activity;
import android.os.Bundle;
import android.widget.TextView;

public class ShowTotal extends Activity {

    private TextView totalTextView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_show_total);

        // get reference to showTotal TextView
        totalTextView = (TextView) findViewById(R.id.sumTextView);

        //retrieve sum value
        Bundle b = getIntent().getExtras();
        int sum = b.getInt("sum");

        // output sum to layout
        totalTextView.setText(Integer.toString(sum));

    }
}

