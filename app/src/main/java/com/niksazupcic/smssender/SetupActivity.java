package com.niksazupcic.smssender;

import androidx.appcompat.app.AppCompatActivity;

import android.app.DatePickerDialog;
import android.app.TimePickerDialog;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.DatePicker;
import android.widget.ImageButton;
import android.widget.Spinner;
import android.widget.TextView;
import android.widget.TimePicker;
import android.widget.ToggleButton;

import java.util.Calendar;
import java.util.Locale;

public class SetupActivity extends AppCompatActivity {

    Spinner option_spinner;
    ImageButton time_button;
    ImageButton date_button;
    ToggleButton notification_button;
    ImageButton done_button;
    TextView time_textView;
    TextView date_textView;
    TextView notification_textView;

    int year;
    int month;
    int day;
    int hour;
    int minute;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_setup);

        option_spinner = findViewById(R.id.option_spinner);
        time_button = findViewById(R.id.time_imageButton);
        date_button = findViewById(R.id.date_imageButton);
        notification_button = findViewById(R.id.notifications_toggleButton);
        done_button = findViewById(R.id.done_imageButton);
        time_textView = findViewById(R.id.time_textView);
        date_textView = findViewById(R.id.date_textView);
        notification_textView = findViewById(R.id.notifications_textView);

        ArrayAdapter<CharSequence> adapter = ArrayAdapter.createFromResource(this,
                R.array.spinner_items, android.R.layout.simple_spinner_item);
        adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        option_spinner.setAdapter(adapter);

        Calendar calendar = Calendar.getInstance();
        year = calendar.get(Calendar.YEAR);
        month = calendar.get(Calendar.MONTH);
        day = calendar.get(Calendar.DAY_OF_MONTH);
        hour = calendar.get(Calendar.HOUR);
        minute = calendar.get(Calendar.MINUTE);

        done_button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(SetupActivity.this, MainActivity.class);
                intent.setFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP);
                startActivity(intent);
            }
        });

        time_button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                TimePickerDialog.OnTimeSetListener onTimeSetListener= new TimePickerDialog.OnTimeSetListener(){
                    @Override
                    public void onTimeSet(TimePicker timePicker, int selectedHour, int selectedMinute) {
                        hour = selectedHour;
                        minute = selectedMinute;
                        time_textView.setText(String.format(Locale.getDefault(), "%02d:%02d", hour, minute));
                    }
                };
                TimePickerDialog timePickerDialog = new TimePickerDialog(SetupActivity.this,
                        onTimeSetListener, hour, minute, true);
                timePickerDialog.show();
            }
        });

        date_button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                DatePickerDialog.OnDateSetListener onDateSetListener= new DatePickerDialog.OnDateSetListener(){
                    @Override
                    public void onDateSet(DatePicker datePicker, int selectedYear, int selectedMonth, int selectedDay) {
                        day = selectedDay;
                        month = selectedMonth;
                        year = selectedYear;
                        date_textView.setText(String.format(Locale.getDefault(), "%02d.%02d.%02d", day, month, year));
                    }
                };
                DatePickerDialog datePickerDialog = new DatePickerDialog(SetupActivity.this,
                        onDateSetListener, year, month, day);
                datePickerDialog.show();
            }
        });
    }
}