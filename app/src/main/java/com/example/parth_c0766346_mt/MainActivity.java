package com.example.parth_c0766346_mt;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.AdapterView.OnItemSelectedListener;
import android.widget.CheckBox;
import android.widget.EditText;
import android.widget.RadioGroup;
import android.widget.SeekBar;
import android.widget.Spinner;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

public class MainActivity extends AppCompatActivity {


    Spinner carSelect;
    EditText rent;
    TextView days, tv_amount, tv_totalAmount;
    SeekBar s_Days;
    RadioGroup ageGroup;
    int d_rent, originalrent, Amount, total_days_rent;
    double finalAmount;
    CheckBox gps, child, unli;
    public static final int GPS = 5;
    public static final int CHILD = 7;
    public static final int UM = 10;
    public static final double TAX = 0.13;
    String d_age;




    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        carSelect = findViewById(R.id.car_select);
        rent = findViewById(R.id.dailyRent);
        final String[] allRent = getResources().getStringArray(R.array.Rents);
        s_Days = findViewById(R.id.no_of_days);
        days = findViewById(R.id.rent_days);
        ageGroup = findViewById(R.id.age);
        originalrent = 0;
        Amount = 0;
        finalAmount = 0.0;
        gps = findViewById(R.id.gps);
        child = findViewById(R.id.child);
        unli = findViewById(R.id.unlimited);
        tv_amount = findViewById(R.id.amt);
        tv_totalAmount = findViewById(R.id.totalAmt);
        total_days_rent = 0;
        d_rent = 0;
        carSelect.setOnItemSelectedListener(new OnItemSelectedListener()
        {

            @Override
            public void onItemSelected(AdapterView<?> adapterView, View view, int i, long l) {

                rent.setText(allRent[i] + " $");
                d_rent = Integer.parseInt(allRent[i]);
                calculateAmount(view);
            }

            public void onNothingSelected(AdapterView<?> parent)
            {

            }
        });

        s_Days.setOnSeekBarChangeListener(new SeekBar.OnSeekBarChangeListener() {
            @Override
            public void onProgressChanged(SeekBar seekBar, int i, boolean b) {
                days.setText(String.valueOf(i));
                total_days_rent = i;
                calculateAmount(seekBar);
            }

            @Override
            public void onStartTrackingTouch(SeekBar seekBar) {

            }

            @Override
            public void onStopTrackingTouch(SeekBar seekBar) {

            }



        });









    }


    public void calculateAmount(View v){


        int id = ageGroup.getCheckedRadioButtonId();
        originalrent = d_rent * total_days_rent ;
        switch(id){

            case R.id.rb1:
                Amount = originalrent + 5;
                d_age = "Less than 20";
                break;
            case R.id.rb2:
                Amount = originalrent;
                d_age = "Between 21 and 60";
                break;
            case R.id.rb3:
                Amount = originalrent - 10;
                d_age = "Above 60";
                break;
            default: break;
        }

        if (gps.isChecked()){

            Amount = Amount + GPS;

        }

        if (child.isChecked()){

            Amount = Amount + CHILD;

        }

        if (unli.isChecked()){

            Amount = Amount + UM;


        }



    finalAmount = Amount + (Amount* TAX);

    tv_amount.setText("Amount: " + String.valueOf(Amount) + " $");
    tv_totalAmount.setText(String.format("Total Payment: %.2f $",finalAmount));


    }

    public void showDetails(View v){

        String options = "\n";

        if (gps.isChecked()){

            options = options +"\n- GPS";

        }

        if (child.isChecked()){

            options = options + "\n- CHILD SEAT";
        }

        if (unli.isChecked()){

            options = options + "\n- UNLIMITED MILLAGE";
        }

        System.out.println(options);

        String car = carSelect.getSelectedItem().toString();
        String dailyRent = String.valueOf(d_rent);
        String no_of_days = String.valueOf(total_days_rent);
        String s_amount = String.valueOf(Amount);
        String s_Total = String.format("Total Payment %.2f $",finalAmount);
        CarInfo c = new CarInfo(car, dailyRent, no_of_days, s_amount, s_Total, options, d_age);
        Intent i = new Intent(MainActivity.this, Details.class );
        i.putExtra("mycardata", c);
        startActivity(i);




    }


}
