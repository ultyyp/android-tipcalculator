package com.example.tipcalculator;

import android.os.Bundle;
import android.widget.EditText;
import android.widget.SeekBar;
import android.widget.TextView;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

import java.util.ArrayList;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class MainActivity extends AppCompatActivity {


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        EditText editText = findViewById(R.id.editText1);
        SeekBar seekBar = findViewById(R.id.seekBar);
        TextView textViewResult = findViewById(R.id.textViewResult);
        TextView textView2 = findViewById(R.id.textView2);

        seekBar.setOnSeekBarChangeListener(new SeekBar.OnSeekBarChangeListener() {
            @Override
            public void onProgressChanged(SeekBar seekBar, int i, boolean b) {


                textView2.setText("Selected Tip Ammount: " + i + "%");
                String text = editText.getText().toString();

                if(!text.isEmpty() && !text.isBlank()){
                    int numbersOnly = extractNumbersToInt(text);
                    textViewResult.setText(String.valueOf(numbersOnly+numbersOnly*(i/100.0)));
                }
                else{
                    textViewResult.setText("");
                }
            }

            @Override
            public void onStartTrackingTouch(SeekBar seekBar) {

            }

            @Override
            public void onStopTrackingTouch(SeekBar seekBar) {

            }
        });






    }

    private int extractNumbersToInt(String text) {
        StringBuilder numbersOnly = new StringBuilder();
        Pattern pattern = Pattern.compile("\\d+");
        Matcher matcher = pattern.matcher(text);

        while (matcher.find()) {
            numbersOnly.append(matcher.group());
        }

        return numbersOnly.length() > 0 ? Integer.parseInt(numbersOnly.toString()) : 0;
    }
}