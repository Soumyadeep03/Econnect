package com.example.myapp;

import androidx.appcompat.app.AppCompatActivity;
import java.util.ArrayList;
import java.util.List;

import android.annotation.SuppressLint;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.SeekBar;
import android.widget.Spinner;
import android.widget.TextView;
import android.widget.Toast;
import android.widget.AdapterView.OnItemSelectedListener;
public class SecondActivity extends  AppCompatActivity implements OnItemSelectedListener {
    SeekBar followerseekBar;
    TextView followertext;
    SeekBar feeseekBar;
    TextView feetext,showdata;
    Button showcreator;
    RadioGroup rg1;
    RadioButton rb1;
    public static int followercriteria,feecriteria,credit;

    String domain,platform;
    int min = 0, max = 100, current = 50;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_second);

        // Spinner element
        Spinner spinner = (Spinner) findViewById(R.id.spinner1);
        showcreator= (Button)findViewById(R.id.showcreator);
        rg1 = (RadioGroup) findViewById(R.id.radioGroup);
        // Spinner click listener
        spinner.setOnItemSelectedListener(this);

        // Spinner Drop down elements
        List<String> categories = new ArrayList<String>();
        categories.add("Gaming");
        categories.add("Vines");
        categories.add("Education");
        categories.add("Lifestyle");


        // Creating adapter for spinner
        ArrayAdapter<String> dataAdapter = new ArrayAdapter<String>(this, android.R.layout.simple_spinner_item, categories);

        // Drop down layout style - list view with radio button
        dataAdapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);

        // attaching data adapter to spinner
        spinner.setAdapter(dataAdapter);
      //seekbar for followers
        followerseekBar= findViewById(R.id.followerseekbar);
        followertext= findViewById(R.id.followertext);
        followerseekBar.setProgress(max - min);
        followerseekBar.setProgress(current - min);
        followertext.setText("" + current);

        followerseekBar.setOnSeekBarChangeListener(new SeekBar.OnSeekBarChangeListener() {
            @Override
            public void onProgressChanged(SeekBar seekBar, int progress, boolean fromUser) {
                current = progress + min;

                followertext.setText("" + current);
                followercriteria = current*10000;

            }

            @Override
            public void onStartTrackingTouch(SeekBar seekBar) { }

            @Override
            public void onStopTrackingTouch(SeekBar seekBar) { }
        });
        //seekbar for fee
        feeseekBar= findViewById(R.id.feeseekbar);
        feetext= findViewById(R.id.feetext);
        feeseekBar.setProgress(max - min);
        feeseekBar.setProgress(current - min);
        feetext.setText("" + current);

        feeseekBar.setOnSeekBarChangeListener(new SeekBar.OnSeekBarChangeListener() {
            @SuppressLint("SetTextI18n")
            @Override
            public void onProgressChanged(SeekBar seekBar, int progress, boolean fromUser) {
                current = progress + min;

                feetext.setText("" + current);
                feecriteria = current;
            }

            @Override
            public void onStartTrackingTouch(SeekBar seekBar) { }

            @Override
            public void onStopTrackingTouch(SeekBar seekBar) { }
        });

        showcreator.setOnClickListener(new View.OnClickListener() {
            @SuppressLint("SetTextI18n")
            @Override
            public void onClick(View v) {
                int selected=rg1.getCheckedRadioButtonId();
                rb1=(RadioButton)findViewById(selected);
                platform = (String) rb1.getText();

                Intent intent = new Intent(SecondActivity.this, thirdactivity.class);
                intent.putExtra("domain", domain);
                intent.putExtra("platform", platform);
                intent.putExtra("followers", followercriteria);
                intent.putExtra("fee", feecriteria);
                startActivity(intent);
                }
        });

    }

    @Override
    public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
        // On selecting a spinner item
       domain= parent.getItemAtPosition(position).toString();

        // Showing selected spinner item

    }

    @Override
    public void onNothingSelected(AdapterView<?> parent) {

    }
}