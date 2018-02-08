package com.example.smeredith.sumcalculator;

import android.app.Activity;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends Activity {

    public static final String EXTRA_MESSAGE = "com.example.smeredith.sumcalculator.SUM";

    //define variables for the widgets
    private EditText editTextNum1;
    private EditText editTextNum2;
    private Button button;
    private TextView textViewSum;

    //define the shared pref object
    private SharedPreferences savedValues;

    //define variables to be saved
    private int num1 = 0;
    private int num2 = 0;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        //get references to the widgets
        editTextNum1 = (EditText) findViewById(R.id.editTextNum1);
        editTextNum2 = (EditText) findViewById(R.id.editTextNum2);
        button = (Button) findViewById(R.id.button);

        //get SharedPreferences object
        savedValues = getSharedPreferences("SavedValues", MODE_PRIVATE);
    }

    @Override public void onPause() {
        SharedPreferences.Editor editor = savedValues.edit();
        editor.putInt("num1", num1);
        editor.putInt("num2", num2);
        editor.commit();
        super.onPause();
    }

    @Override public void onResume() {
        super.onResume();
        num1 = savedValues.getInt("num1", 0);
        num2 = savedValues.getInt("num12", 0);
    }

    public void showTotal(View view) {
        // Show sum of mum1 and num2 in new activity
        Intent showIntent = new Intent(MainActivity.this, ShowTotal.class);

        // get current values of num1, num2
        num1 = Integer.parseInt(editTextNum1.getText().toString());
        num2 = Integer.parseInt(editTextNum2.getText().toString());

        int sum = num1 + num2;

        showIntent.putExtra("sum", sum);

        startActivity(showIntent);

    }

}
