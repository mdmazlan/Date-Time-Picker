package com.mdmazlan.datetimepicker;

import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.DialogFragment;

import android.annotation.SuppressLint;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.DatePicker;
import android.widget.TextView;
import android.widget.TimePicker;

import java.text.DateFormat;
import java.util.Calendar;

public class MainActivity extends AppCompatActivity implements DatePickerFragment.DatePickerListener,
        TimePickerFragment.TimePickerListener{

        TextView tv_output_date_v;
        TextView tv_output_time_v;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        //TextView Date Output......................................................................

        tv_output_date_v = findViewById(R.id.tv_output_date_id);
        Button btn_pick_date_v = findViewById(R.id.btn_pick_date_id);


        //Button for time Picker....................................................................
        tv_output_time_v = findViewById(R.id.tv_output_time_id);
        Button btn_pick_time_v = findViewById(R.id.btn_pick_time_id);



        //Code For Date Picker on Button............................................................

        btn_pick_date_v.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View v) {
                DialogFragment datePickerFragment=new DatePickerFragment();
                datePickerFragment.setCancelable(false);
                datePickerFragment.show(getSupportFragmentManager(),"date Picker");

            }
        });


        //Code For Time Picker on Button............................................................

        btn_pick_time_v.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                DialogFragment timePickerFragment = new TimePickerFragment();
                timePickerFragment.setCancelable(false);
                timePickerFragment.show(getSupportFragmentManager(), "timePicker");
            }
        });
    }


    @Override
    public void onDateSet(DatePicker datePicker, int year, int month, int day) {
        Calendar cal=Calendar.getInstance();
        cal.set(Calendar.YEAR,year);
        cal.set(Calendar.MONTH,month);
        cal.set(Calendar.DAY_OF_MONTH,day);
        String date= DateFormat.getDateInstance().format(cal.getTime());
        tv_output_date_v.setText(date);
    }

    @SuppressLint("SetTextI18n")
    @Override
    public void onTimeSet(TimePicker timePicker, int hour, int minute) {
        tv_output_time_v.setText(+ hour +" hour, " + minute + " Minute");
    }

}