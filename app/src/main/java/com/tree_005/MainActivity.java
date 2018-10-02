package com.tree_005;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import java.text.DecimalFormat;

public class MainActivity extends AppCompatActivity {

    DecimalFormat temperature = new DecimalFormat("####0.0");
    //double speedOfSoundHoldValue = 0;
    //boolean afterFirstClick = false;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        Button calculationButton = (Button) findViewById(R.id.calculationButton);
        calculationButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                EditText speedOfSoundEditText = (EditText) findViewById(R.id.speedOfSoundEditText);
                TextView temperatureCelsiusTextView = (TextView) findViewById(R.id.CelsiusTemperatureTextView);
                TextView temperatureFahrenheitTextView = (TextView) findViewById(R.id.FahrenheitTemperatureTextView);
                //if (afterFirstClick) speedOfSoundEditText.setText(temperature.format(speedOfSoundHoldValue) + "");
                //speedOfSoundHoldValue = Double.parseDouble(speedOfSoundEditText.getText().toString());
                String speedOfSoundString = speedOfSoundEditText.getText().toString();
                if (speedOfSoundString.endsWith(" Km/Hr")) speedOfSoundString.replace(" Km/Hr","");
                double speedOfSound = Double.parseDouble(speedOfSoundEditText.getText().toString())/3.6;
                double ambientTemperatureCelsius = (speedOfSound-331.3)/(0.606);
                double ambientTemperatureFahrenheit = (ambientTemperatureCelsius*1.8)+32;
                temperatureCelsiusTextView.setText(temperature.format(ambientTemperatureCelsius)+" Celsius");
                temperatureFahrenheitTextView.setText(temperature.format(ambientTemperatureFahrenheit)+" Fahrenheit");
                //speedOfSoundHoldValue = speedOfSound * 3.6;
                //speedOfSoundEditText.setText(temperature.format(speedOfSound * 3.6) + " Km/Hr");
                speedOfSoundEditText.setText(temperature.format(speedOfSound * 3.6));
                //afterFirstClick = true;
            }
        });

    }
}
