package com.example.parth_c0766346_mt;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.widget.TextView;

public class Details extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_details);

        Intent i = getIntent();
        CarInfo cd = (CarInfo) i.getSerializableExtra("mycardata");

        TextView summary = findViewById(R.id.data);

        String l1 = "Detailed Summary\n\n\n\n";
        String l2 = "Selected Car : " + cd.carName + "\n\n";
        String l3 = "Daily Rent : " + cd.dailyRent + "\n\n";
        String l4 = "No of days : " + cd.no_of_days +"\n\n";
        String l5 = "Driver Age : " + cd.d_age +"\n\n";
        String l6 = "Selected Options : " + cd.options + "\n\n";
        String l7 = "Amount : " + cd.s_amount +" $\n\n";
        String l8 = cd.s_Total + "\n\n";

        summary.setText(l1 + l2 + l3 + l4 + l5 + l6 + l7 + l8);


    }
}
